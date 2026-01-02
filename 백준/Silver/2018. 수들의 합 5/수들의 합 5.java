import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[(N/2) + 1 + 1];

        for (int i=1; i<arr.length; i++) {
            arr[i] = i;
        }

        int startIdx = 1;
        int endIdx = 1;
        int sum = 0;
        int cnt = 1;

        while (startIdx < arr.length-1) {
            if (sum >= N) {
                if (sum == N) {
                    cnt++;
                }
                sum -= arr[startIdx];
                startIdx++;
            } else if (endIdx == N && sum < N) {
                break;
            } else {
                sum += arr[endIdx];
                endIdx++;
            }
            
        }
        System.out.println(cnt);
    }
}