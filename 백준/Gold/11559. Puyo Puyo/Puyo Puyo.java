import java.io.*;
import java.util.*;

class Main {

    static char[][] graph = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> tmpGraph = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i=0; i<12; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j=0; j<6; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        moveGraph();
        
        while(true) {
            // System.out.println("몇 번 실행?");
            visited = new boolean[12][6];
            boolean fang = false;
            for (int i=0; i<12; i++) {
                for (int j=0; j<6; j++) {
                    if (graph[i][j] != '.' && !visited[i][j]) {
                        bfs(new int[]{i, j, 0});
                        if (tmpGraph.size() < 4) {
                            tmpGraph.clear();
                        } else {
                            fang = true;
                            for (int[] a : tmpGraph) {
                                graph[a[0]][a[1]] = '.';
                            }
                            tmpGraph.clear();
                        }
                    }

                }
            }
            if (fang) {
                cnt++;
                moveGraph();

                // System.out.println("그래프 정렬 후");

                // for (int i=0; i<12; i++) {
                //     for (int j=0; j<6; j++) {
                //         System.out.print(graph[i][j]);
                //     }
                //     System.out.println();
                // }
                // System.out.println();
            } else {
                break;
            }
        }
        System.out.println(cnt);

    }

    public static void moveGraph() {
        for (int i=11; i>=0; i--) {
            for (int j=0; j<6; j++) {
                if (graph[i][j]== '.') {
                    continue;
                } else {
                    int cnt = i;
                    while (true) {
                        if (cnt +1 < 12 && graph[cnt+1][j] == '.') {
                            graph[cnt+1][j] = graph[cnt][j];
                            graph[cnt][j] = '.';
                            cnt+=1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int current[] = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentValue = current[2];
        
            for (int i=0; i<4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) {
                    continue;
                }

                if (graph[nx][ny] == '.') {
                    continue;
                }

                if (visited[nx][ny] || graph[nx][ny] != graph[currentX][currentY]) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, currentValue + 1});
                tmpGraph.add(new int[]{nx, ny});
            }
        }
    }
}