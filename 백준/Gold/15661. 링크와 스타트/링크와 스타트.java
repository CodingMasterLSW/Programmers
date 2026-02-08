import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=1; i< (N/2) + 1; i++) {
            backtracking(0, i, 0);
        }
        System.out.println(minValue);
    }

    public static void backtracking(int depth, int currentMax, int start) {
        if (depth == currentMax) {
            // 여기서 스타트, 링크 팀 계산 로직
            List<Integer> startTeam = new ArrayList<>();
            List<Integer> linkTeam = new ArrayList<>();
            for (int i=0; i<N; i++) {
                if (visited[i]) {
                    startTeam.add(i);
                } else {
                    linkTeam.add(i);
                }
            }
            
            int sum1 = 0;
            for (int i=0; i<startTeam.size(); i++) {
                for (int j=0; j<startTeam.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    sum1 += graph[startTeam.get(i)][startTeam.get(j)];                    
                }
            }

            int sum2 = 0;
            for (int i=0; i<linkTeam.size(); i++) {
                for (int j=0; j<linkTeam.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    sum2 += graph[linkTeam.get(i)][linkTeam.get(j)];                    
                }
            }
            minValue = Math.min(Math.abs(sum1 - sum2), minValue);
            return;
        }

        for (int i=start; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(depth + 1,currentMax, i+1);
            visited[i] = false;
        }
    }
}