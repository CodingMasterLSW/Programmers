import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        int cnt = 0;
        for(int i=0; i<N; i++){
            if(input[i] == 'P'){
                for(int j= Math.max(0, i-K); j<=Math.min(N-1, i+K); j++) {
                    if (input[j] == 'H') {
                        cnt++;
                        input[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
