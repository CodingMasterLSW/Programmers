import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lists = new int[M];

        for(int i = 0; i < M; i++){
            lists[i] = Integer.parseInt(st.nextToken());
        }

        int maxDistance = Math.max(lists[0] - 0, N - lists[M-1]);

        for(int i = 1; i < M; i++){
            int distance = (lists[i] - lists[i-1] + 1) / 2;
            if(distance > maxDistance){
                maxDistance = distance;
            }
        }

        System.out.println(maxDistance);
    }
}