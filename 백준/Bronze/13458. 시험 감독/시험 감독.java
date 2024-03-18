

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int B;
    static int C;

    static int[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        lists = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            lists[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long cnt = 0;

        for(Integer list : lists){
            int calculateList = list- B;
            cnt++;
            if(calculateList>0){
                cnt += calculateList/C;
                if(calculateList%C != 0){
                    cnt++;
                }
            }

        }
        System.out.println(cnt);
    }

}
