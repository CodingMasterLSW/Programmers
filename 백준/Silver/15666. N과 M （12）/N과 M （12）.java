import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] resources = new int[M];
        backtracking(N, M, resources, 0, 0);
        System.out.println(sb.toString());

    }

    public static void backtracking(int n, int m, int[] resources, int depth, int start) {
        if (M == depth) {
            for (int i = 0; i < M; i++) {
                sb.append(resources[i] + " ");
            }
            sb.append("\n");
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < N; i++) {
            if (!used.contains(arr[i])) {
                resources[depth] = arr[i];
                backtracking(N, M, resources, depth + 1, i);
                used.add(arr[i]);
            }

        }
    }

}
