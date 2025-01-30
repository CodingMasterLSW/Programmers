
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int maxLeft = arr[0];
        int maxRight = 0;
        for (int i=2; i<M; i++) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
            }
        }

        for (int i=1; i<M-1; i++) {
            int min = Math.min(maxLeft, maxRight);
            int cal = min - arr[i];

            if (cal>0) {
                sum += cal;
            }

            // 오른쪽 최대값 재탐색
            maxRight = 0;
            maxLeft = 0;
            for (int j=i+2; j<M; j++) {
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                }
            }
            // 왼쪽 최대값 재탐색
            for (int j=0; j<=i; j++) {
                if (arr[j] > maxLeft) {
                    maxLeft = arr[j];
                }
            }
        }
        System.out.println(sum);
    }
}
