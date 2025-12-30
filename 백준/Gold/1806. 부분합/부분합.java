import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int S;
    static int[] arr;
    static int minValue = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;

        while(endIdx <= N) {
            if (sum < S) {
                sum += arr[endIdx];
                endIdx ++;
            } else if (sum >= S) {
                sum -= arr[startIdx];
                startIdx++; 
            }

            if (sum >= S) {
                minValue = Math.min(minValue, (endIdx - startIdx));
            }
        }

        if (minValue == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(minValue);
    }
}