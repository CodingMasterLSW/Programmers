import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[length+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for(int i=0; i<N; i++){
            sum += arr[i];
        }

        int maxSum = sum;
        int idx = 0;
        for(int i=N; i<length; i++){
            sum -= arr[idx];
            sum += arr[N+idx];
            idx++;

            if(sum>maxSum){
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }

}
