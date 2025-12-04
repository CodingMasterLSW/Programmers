// 꽃의 씨앗은 3개 고정
// 위치마다 비용 존재
// 3개 심을 때 최소 대여료 구하기

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] field;
    static int[][] arr = new int[3][2];
    static boolean[][] visited;
    static int minValue = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            for (int j=0; j<N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0);
        System.out.println(minValue);
    }
    public static void backtracking(int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i=0; i<3; i++) {
                int[] currentLocation = arr[i];
                sum += field[currentLocation[0]][currentLocation[1]];
                for (int a = 0; a < 4; a ++) {
                    int nx = currentLocation[0] + dx[a];
                    int ny = currentLocation[1] + dy[a];
                    sum += field[nx][ny];
                }
            }
            minValue = Math.min(sum, minValue);
            return;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!canVisit(i,j)) {
                    continue;
                }

                if (visited[i][j]) {
                    continue;
                }
                changeVisited(i,j);
                arr[depth] = new int[]{i,j};
                backtracking(depth + 1);
                changeNotVisited(i,j);
            }
        }
    }

    public static boolean canVisit(int x, int y) {
        for (int a = 0; a < 4; a++) {
            int ndx = x + dx[a];
            int ndy = y + dy[a];

            if (ndx < 0 || ndx >=N || ndy < 0 || ndy >= N) {
                return false;
            }

            if (visited[ndx][ndy]) {
                return false;
            }
        }
        return true;
    }

    public static void changeVisited(int x, int y) {
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];

            visited[ndx][ndy] = true;
        }
    }

    public static void changeNotVisited(int x, int y) {
        visited[x][y] = false;
        for (int i=0; i<4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];

            visited[ndx][ndy] = false;
        }
    }
}