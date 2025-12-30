

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
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int cnt = 0;

        while (end <= length) {
            if(sum>=N){
                sum -= arr[start++];
            }
            else if(sum<N){
                sum += arr[end++];
            }
            if(sum==N){
                cnt++;
            }

        }
        System.out.println(cnt);
    }

}
