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
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recursion(0);
        System.out.println(sb.toString());
    }

    public static void recursion(int depth) {
        if (M == depth) {
            for (int a : result) {
                sb.append(a + " ");
            }
            sb.append("\n"); 
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                recursion(depth + 1);
                visited[i] = false;
            }
        }
    }
}