import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N];

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] resources = new int[M];

        backtracking(N, M, visited, resources, 0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int n, int m, boolean[] visited, int[] resources, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(resources[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            resources[depth] = arr[i];
            backtracking(n, m, visited, resources, depth + 1);
        }
    }
}


