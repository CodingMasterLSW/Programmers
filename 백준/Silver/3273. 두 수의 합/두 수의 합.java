import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;
        int cnt = 0;
        Arrays.sort(arr);

        while(start<end){
            int sum = arr[start] + arr[end];
            if(sum<=res){
                start++;
                if(sum==res){
                    cnt++;
                }
            } else if(sum>res){
                end--;
            }
         }
        System.out.println(cnt);
    }

}
