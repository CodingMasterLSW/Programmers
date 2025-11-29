import java.io.*;
import java.util.*;
class Main {
    
    static int N;
    static int M;
    static int[][] graph;
    static int minValue;
    static List<int[]> currentChicken = new ArrayList<>();
    static List<int[]> startPoint = new ArrayList<>();
    static List<int[]> chickenPoint = new ArrayList<>();
    static int finalResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    startPoint.add(new int[]{i,j});
                }
                if (graph[i][j] == 2) {
                    chickenPoint.add(new int[] {i,j});
                }
            }
        }
        backtracking(0);
        System.out.println(finalResult);

    }

    public static void backtracking(int start) {
        if (currentChicken.size() == M) {
            cal();
            return;
        }

        for (int i=start; i<chickenPoint.size(); i++) {
            int[] target = chickenPoint.get(i);
            currentChicken.add(target);
            backtracking(i + 1);
            currentChicken.remove(target);
        }
    }

    public static void cal() {
        // startPoint -> currentChicken 거리를 전부 돌아야해요.
        // -> 그러니깐, 2중 반복문이 필요하다.
        int result = 0;

        for (int[] start : startPoint) {
            int minValue = Integer.MAX_VALUE;
            for (int[] cur : currentChicken) {
                int calValue = Math.abs(start[0] - cur[0]) + Math.abs(start[1] - cur[1]);
                minValue = Math.min(minValue, calValue);
            }
            result += minValue;
        }
        finalResult = Math.min(result, finalResult);
    }
}