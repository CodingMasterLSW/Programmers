
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];
        recursion(0, 0);
    }

    public static void recursion(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int a : arr) {
                sb.append(a);
                sb.append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i=start; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                recursion(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
