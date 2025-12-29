import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int[] arr;
    static boolean[] visited;
    static int[] current;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        current = new int[K];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        backtracking(0);
        System.out.println(result.size());
    }

    public static void backtracking(int depth) {
        if (depth == K) {
            StringBuilder sb = new StringBuilder();

            for (int i=0; i<K; i++) {
                sb.append(current[i]);
            }

            int target = Integer.parseInt(sb.toString());

            if (!result.contains(target)) {
                result.add(target);
            }
        
            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            // if (i>0 && (!visited[i] && (!visited[i-1])) && arr[i] == arr[i-1]) {
            //     continue;
            // }

            visited[i] = true;
            current[depth] = arr[i];
            backtracking(depth + 1);
            visited[i] = false;
        }
    }
}