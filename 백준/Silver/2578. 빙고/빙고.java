import java.io.*;
import java.util.*;

class Main {

    static int[][] graph = new int[5][5];
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                int target = Integer.parseInt(st.nextToken());
                int[] location = findLocation(target);
                int row = location[0];
                int column = location[1];
                visited[row][column] = true;
                cnt++;
                int bingo = isBingo();
    
                if (bingo >= 3) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    public static int isBingo() {
        //행, 열, 대각
        int cnt = 0;

        for (int i=0; i<5; i++) {
            boolean isBingo = true;
            for (int j=0; j<5; j++) {
                if (!visited[i][j]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                cnt++;
            }
        }
        
        for (int i=0; i<5; i++) {
            boolean isBingo = true;
            for (int j=0; j<5; j++) {
                if (!visited[j][i]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                cnt++;
            }
        }

        boolean isBingo = true;
        for (int i=0; i<5; i++) {
            if(!visited[i][i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            cnt++;
        }

        isBingo = true;
        for (int i=0; i<5; i++) {
            if (!visited[4-i][i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            cnt++;
        }

        return cnt;
    }

    public static int[] findLocation(int target) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (graph[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}