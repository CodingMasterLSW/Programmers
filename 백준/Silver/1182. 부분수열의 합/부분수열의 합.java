import java.util.*; 

public class Main {

    static int[] arr;
    static int cnt;
    static int current;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        backtracking(N, 0, 0);
        System.out.println(cnt);
    }

    public static void backtracking(int N, int depth, int start) {
        if (current == M && depth > 0) {
            cnt++;
        }

        for (int i = start; i < N; i++) {
            current += arr[i];
            backtracking(N, depth + 1, i + 1);
            current -= arr[i];
        }
    }

}
    
