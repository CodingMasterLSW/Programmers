import java.io.*;
import java.util.*;

class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (arr.length == 1) {
            System.out.println(1);
            return;
        }

        int maxValue = 0;

        // 오름차순 판별
        int tmpCount = 1;
        for (int i=1; i<N; i++) {
            if (arr[i] >= arr[i-1]) {
                tmpCount++;
                maxValue = Math.max(tmpCount, maxValue);
            } else {
                maxValue = Math.max(tmpCount, maxValue);
                tmpCount = 1;
            }
        }

        // 내림차순 판별
        int maxValue2 = 0;
        int tmpCount2 = 1;
        for (int i=1; i<N; i++) {
            if (arr[i] <= arr[i-1]) {
                tmpCount2 ++;
                maxValue2 = Math.max(tmpCount2, maxValue2);
            } else {
                maxValue2 = Math.max(tmpCount2, maxValue2);
                tmpCount2 = 1;
            }
        }

        System.out.println(Math.max(maxValue, maxValue2));
    }
}
// 한... 실버 5? 