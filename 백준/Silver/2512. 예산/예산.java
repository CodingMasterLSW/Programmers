import java.io.*;
import java.util.*;

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

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());

        if(M>=sum){
            System.out.println(arr[N-1]);
        } else{

            long start = 0;
            long end = arr[N-1];
            long result = 0;

            while(start<=end){
                long mid = (start+end)/2;
                long s = 0;

                for(long v : arr){
                    if(v>=mid){
                        s+=mid;
                    } else{
                        s+=v;
                    }
                }
                if(s>M){
                    end = mid-1;
                } else{
                    start = mid+1;
                    result = Math.max(result, mid);
                }
            }
            System.out.println(result);
        }
    }

}
