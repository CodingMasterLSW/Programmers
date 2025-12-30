import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] arr;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 0;

        Map<Integer, Integer> histories = new HashMap<>();
        
        while(endIdx < N) {
            histories.put(arr[endIdx], histories.getOrDefault(arr[endIdx], 0) + 1);

            if (histories.get(arr[endIdx]) > M) {

                while (true) {
                    if (histories.get(arr[endIdx]) <= M) {
                        break;
                    }
                    histories.put(arr[startIdx], histories.get(arr[startIdx]) - 1);
                    startIdx++;
                }
            }
            endIdx ++;
            maxValue = Math.max(maxValue, endIdx - startIdx);
        }
        System.out.println(maxValue);
    }
}