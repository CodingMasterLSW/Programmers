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
        recursion(0, 1);
        System.out.println(sb.toString());
    }

    public static void recursion(int depth, int start) {
        if (M == depth) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<=N; i++) {
            arr[depth] = i;
            recursion(depth + 1, i);
        }
    }
}