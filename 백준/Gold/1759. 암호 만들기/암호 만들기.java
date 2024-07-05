import java.util.*;

public class Main {

    static int N;
    static int M;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new char[M];
        for (int i = 0; i < M; i++) {
            arr[i] = (sc.next()).charAt(0);
        }
        Arrays.sort(arr);

        char[] resources = new char[N];
        backtracking(0, resources, 0);
        
        System.out.print(sb.toString());
    }

    public static void backtracking(int depth, char[] resources, int start) {

        if (N == depth) {
            int aCount = 0;
            int bCount = 0;
            for (int i = 0; i < N; i++) {
                if (resources[i] == 'a' || resources[i] == 'e' || resources[i] == 'i'
                        || resources[i] == 'o' || resources[i] == 'u') {
                    aCount++;
                } else {
                    bCount++;
                }
            }
            if (aCount >= 1 && bCount >= 2) {
                for (int i = 0; i < N; i++) {
                    sb.append(resources[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < M; i++) {
            resources[depth] = arr[i];
            backtracking(depth + 1, resources, i+1);

        }
    }
}
