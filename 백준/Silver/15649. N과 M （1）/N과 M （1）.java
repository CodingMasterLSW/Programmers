import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        recursion(0);
    }

    public static void recursion(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int a : arr) {
                sb.append(a).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                recursion(depth+1);
                visited[i] = false;
            }
        }
    }
}