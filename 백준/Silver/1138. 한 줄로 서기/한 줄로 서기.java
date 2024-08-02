import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 작은 수 부터 넣기
        for(int i=1; i<=N; i++){
            int pos = 0;
            int cnt = arr[i-1];

            while(cnt>0 || result[pos] != 0){
                if(result[pos] == 0){
                    cnt--;
                }
                pos++;
            }
            result[pos] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(result[i]+" ");
        }
        System.out.println(sb.toString());
    }

}
