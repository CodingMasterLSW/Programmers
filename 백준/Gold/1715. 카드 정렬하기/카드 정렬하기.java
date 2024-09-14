import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            pq.offer(a);
        }

        int sum = 0;

        while(pq.size()>1){
            int idx1 = pq.poll();
            int idx2 = pq.poll();
            int addIdx = idx1 + idx2;
            sum += addIdx;
            pq.offer(addIdx);
        }
        System.out.println(sum);
    }

}
