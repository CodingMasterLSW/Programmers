import java.io.*;
import java.util.*;

class Main {

    static int N;
    static List<List<Integer>> areas = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int minValue = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        result = new int[N]; 
        visited[0] = true;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            for (int j=0; j<N; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            areas.add(arr);
        }
        backtracking(1);
        System.out.println(minValue);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            int compareValue = 0;
            for (int i=0; i<N; i++) {
                if (i == N-1) {
                    int idx = result[i];
                    int finalValue = areas.get(idx).get(0);
                    if (finalValue == 0) {
                        return;
                    }
                    compareValue += areas.get(idx).get(0);
                    break;
                }
                int idx = result[i];
                List<Integer> arr = areas.get(idx);
                if (arr.get(result[i+1]) == 0) {
                    return;
                }
                compareValue += arr.get(result[i+1]);
            }
            minValue = Math.min(compareValue, minValue);
            return;
        }

        for (int i=1; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[depth] = i;
            backtracking(depth + 1);
            visited[i] = false;
        }
    }
    
}