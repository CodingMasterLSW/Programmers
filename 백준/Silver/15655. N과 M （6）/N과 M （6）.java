import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int M;
    static int[] result;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth, int start) {
        // 종료조건
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
    
        for (int i=start; i<arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            result[depth] = arr[i];
            backtracking(depth + 1, i);
            visited[i] = false;
        }

    }
}