import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int M;
    static int[] arr;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int startIdx = 0;
        int endIdx = 0;

        while (endIdx < N) {
            int start = arr[startIdx];
            int end = arr[endIdx];
            int cal = Math.abs(start - end);

            if (cal == M) {
                minValue = Math.min(cal, minValue);
                break;
            }
            if (cal > M) {
                minValue = Math.min(cal, minValue);
                startIdx++;
            }
            if (cal < M) {
                endIdx++;
            }
        }
        System.out.println(minValue);
    }
}