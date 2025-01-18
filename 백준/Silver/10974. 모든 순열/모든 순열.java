import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N+1];
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int a : arr) {
                sb.append(a);
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
