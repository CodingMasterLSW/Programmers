import java.io.*;
import java.util.*;

class Main {

    static char[][] graph = new char[12][6];
    static boolean[][] visited;
    static List<int[]> visitedHistory;

    static int[] r = {-1, 1, 0, 0};
    static int[] c = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<12; i++) {
            String s = br.readLine();
            for (int j=0; j<6; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        int totalCount = 0;

        boolean flag = true;
        while (flag) {
            flag = false;
            visited = new boolean[12][6];
            for (int i=0; i<12; i++) {
                for (int j=0; j<6; j++) {
                    if (graph[i][j] == '.' || visited[i][j]){
                        continue;
                    }
                    visitedHistory = new ArrayList<>();
                    visitedHistory.add(new int[]{i, j});
                    bfs(new int[]{i, j});

                    if (visitedHistory.size() >= 4) {
                        flag = true;
                        for (int[] history : visitedHistory) {
                            int row = history[0];
                            int column = history[1];
                            graph[row][column] = '.';
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            down();
            totalCount ++;
        }
        System.out.println(totalCount);
    }

    // 역순으로 가야할듯? 
    public static void down() {
        for (int i=11; i>=0; i--) {
            for (int j=5; j>=0; j--) {
                if (graph[i][j] == '.') {
                    continue;
                }
                
                int cur = i;
                while (true) {
                    if (cur + 1 > 11 || graph[cur + 1][j] != '.') {
                        break;
                    }
                    graph[cur + 1][j] = graph[cur][j];
                    graph[cur][j] = '.';
                    cur++;
                }
            }
        }
    }

    public static void bfs(int[] startPoint) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(startPoint);
        visited[startPoint[0]][startPoint[1]] = true;
        int maxValue = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int nRow = current[0] + r[i];
                int nCol = current[1] + c[i];

                if (nRow < 0 || nRow >= 12 || nCol < 0 || nCol >= 6) {
                    continue;
                }
                if (visited[nRow][nCol]) {
                    continue;
                }
                if (graph[nRow][nCol] != graph[current[0]][current[1]]) {
                    continue;
                }

                visited[nRow][nCol] = true;
                q.offer(new int[]{nRow, nCol});
                visitedHistory.add(new int[]{nRow, nCol});
            }
        }
    }
}