import java.io.*;
import java.util.*;


class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 0;
        long sum = 0;

        int[] histories = new int[100005];

        while(endIdx < N) {
    
            histories[arr[endIdx]] = histories[arr[endIdx]] + 1;

            int currentValue = histories[arr[endIdx]];

            endIdx++;

            if (currentValue > 1) {
                while(true) {
                    if (histories[arr[endIdx -1]] <= 1) {
                        sum += endIdx - startIdx;
                        break;
                    }
                    histories[arr[startIdx]] = histories[arr[startIdx]]-1;
                    startIdx ++;
                }
            } else {
                sum += endIdx - startIdx;
            }
        }
        System.out.println(sum);
    }
}