import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(binary(arr, N, M));
    }

    private static int binary(final int[] arr, final int N, final int M) {
        int start = 1;
        int end = arr[arr.length - 1];

        int maxResult = 0;
        while (start <= end) {
            int middle = (start + end) / 2;

            int cnt = 0;
            for (int i=0; i<N; i++) {
                cnt += arr[i] / middle;
                if (cnt > M) {
                    break;
                }
            }

            if (cnt>=M) {
                maxResult = middle;
                start = middle + 1;
            }

            if (cnt < M) {
                end = middle - 1;
            }
        }
        return maxResult;
    }
}
