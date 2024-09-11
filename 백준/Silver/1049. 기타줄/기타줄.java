import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //끊어진 기타줄 개수
        int M = Integer.parseInt(st.nextToken());
        int money = 0;

        int[] set = new int[M];
        int[] one = new int[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            set[i] = first;
            one[i] = second;
        }
        Arrays.sort(set);
        Arrays.sort(one);

        while(N>0) {
            if(N<=6){
                if(N*one[0]>set[0]){
                    N -= 6;
                    money += set[0];
                } else{
                    N -= 1;
                    money += one[0];
                }

            } else{
                if(one[0] * 6 > set[0]){
                    N -= 6;
                    money += set[0];
                } else{
                    N -= 1;
                    money += one[0];
                }

            }
        }
        System.out.println(money);
    }

}
