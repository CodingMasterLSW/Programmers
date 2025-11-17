import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        recursion(0);
        System.out.println(sb.toString());
    }

    public static void recursion(int depth) {
        if (depth == M) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                recursion(depth + 1);
                visited[i] = true;
            }            
            visited[i] = false;
        }
    }
}