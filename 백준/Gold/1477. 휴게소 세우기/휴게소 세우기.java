import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = L;
        Arrays.sort(arr);

        int low = 0;
        int high = L;

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if(check(mid)) {
                high = mid;
            }else {
                low = mid;
            }
        }
//        check(300);
        System.out.println(high);
    }

    private static boolean check(int target) {
        // target은 휴게소가 없는 구간의 최대길이
        int cnt = 0;
        int index = 0;
        int prevPos = 0;
        while (index <= N) {
//            System.out.println("arr[index] - prevPos = " + (arr[index] - prevPos) + " target = " + target);
            if(arr[index] - prevPos <= target) {
                prevPos = arr[index];
                index++;
            }else {
                prevPos += target;
                cnt++;
                while (arr[index] <= prevPos) {
                    index++;
                }
            }
        }
//        System.out.println("cnt = " + cnt);
        return cnt <= M;
    }
}
