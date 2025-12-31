import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 0;
        int maxCount = 0;

        int odd = 0;
        int even = 0;
        // 마지막까지 계산을 해야하니깐...
        while(endIdx < N) {
            if (arr[endIdx] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            endIdx++;
            if (odd > K) {
                while(true) {
                    if (odd <= K) {
                        break;
                    }
                    if (arr[startIdx] % 2 == 0) {
                        even--;
                    } else {
                        odd--;
                    }
                    startIdx++;
                }
                // start 늘리는 로직
            } else {
                maxCount = Math.max(maxCount, even);
            }
        }
        System.out.println(maxCount);
    }
}