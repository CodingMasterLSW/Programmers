import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = arr.length -1;
        int cnt = 0;

        Arrays.sort(arr);

        while(startIdx != endIdx) {
            int sum = arr[startIdx] + arr[endIdx];
            if (sum <= M) {
                if (sum == M) {
                    cnt++;
                }
                startIdx++;
            } else if (sum > M) {
                endIdx--;
            }
        }
        System.out.println(cnt);
    }
}