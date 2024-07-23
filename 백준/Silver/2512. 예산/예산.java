import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+= arr[i];
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if(sum<=M){
            System.out.println(arr[N-1]);
        } else{
            int start = 0;
            int end = arr[N-1];
            int mid = 0;
            int result = 0;

            while(start<=end){
                int s = 0;
                mid = (start+end)/2;

                for(int v : arr){
                    if(v>=mid){
                        s+=mid;
                    } else{
                        s+=v;
                    }
                }

                if(s<=M){
                    start = mid+1;
                    result = Math.max(result, mid);
                } else{
                    end = mid-1;
                }
            }
            System.out.println(result);
        }
    }
}
