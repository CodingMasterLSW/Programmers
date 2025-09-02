import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        N = sc.nextInt();

        int[] arr = new int[K];
        for (int i=0; i<K; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[arr.length - 1] + 1L;

        while (start + 1 < end) {
            long middle = (start + end) /2;

            if (check(K, arr, middle)) {
                start = middle;
            }else {
                end = middle;
            }
        }
        System.out.println(start);
    }

    private static boolean check(final int K, final int[] arr, final long middle) {
        int cnt = 0;
        for (int i=0; i< K; i++) {
            cnt += arr[i] / middle;
        }
        return cnt >= N;
    }
}
