import java.io.*;
import java.util.*;

class Main {
    
    static int score = 0;
    static int N;
    static int startPlayerNumber = 0;
    static boolean[] field = new boolean[3];
    static boolean[] visited = new boolean[10];

    static int[] player = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] playerCombination = new int[9];
    static List<int[]> games = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmpArr = new int[9];
            for (int j=0; j<9; j++) {
                tmpArr[j] = Integer.parseInt(st.nextToken());
            }
            games.add(tmpArr);
        }

        backtracking(0);
        System.out.println(score);
    }

    public static void backtracking(int depth) {
        if (depth == 3) {
            playerCombination[3] = player[0];
            visited[1] = true;
            backtracking(depth + 1);
            visited[1] = false;
            return;
        }
        if (depth == 9) {
            int currentValue = 0;

            field = new boolean[3];
            startPlayerNumber = 0;

            for (int[] game : games) {
                // 조합한 타순을 해당 game의 idx에 넣어서 실행하면 됌
                // game : 1 이닝을 의미함
                currentValue += play(game);
            }
            score = Math.max(score, currentValue);
            return;
        }

        for (int i=1; i<9; i++) {
            int playerNumber = player[i];
            if (!visited[playerNumber]) {
                visited[playerNumber] = true;
                playerCombination[depth] = playerNumber;
                backtracking(depth + 1);
                visited[playerNumber] = false;
            }
        }
    }
    
    public static int play(int[] game) {
        int currentScore = 0;
        int outCount = 0;
        field = new boolean[3];
        while (outCount != 3) {
            int hitter = playerCombination[startPlayerNumber % 9];
            int result = game[hitter -1];
            if (result == 1) {
                if (field[2] == true) {
                    field[2] = false;
                    currentScore ++;
                }
                field[2] = field[1];
                field[1] = field[0];
                field[0] = true;
            }
            if (result == 2) {
                if (field[2] == true) {
                    field[2] = false;
                    currentScore ++;
                }
                if (field[1] == true) {
                    field[1] = false;
                    currentScore ++;
                }
                field[2] = field[0]; 
                field[0] = false;
                field[1] = true;
            }

            if (result == 3) {
                if (field[2] == true) {
                    field[2] = false;
                    currentScore ++;
                }
                if (field[1] == true) {
                    field[1] = false;
                    currentScore ++;
                }
                if (field[0] == true) {
                    field[0] = false;
                    currentScore ++;
                }
                field[2] = true;
            }
            
            if (result == 0) {
                outCount ++;
            }
  
            if (result == 4) {
                if (field[2] == true) {
                    field[2] = false;
                    currentScore ++;
                }
                if (field[1] == true) {
                    field[1] = false;
                    currentScore ++;
                }
                if (field[0] == true) {
                    field[0] = false;
                    currentScore ++;
                }
                currentScore ++;
            }
            startPlayerNumber++;
        }
        return currentScore;
    }
}