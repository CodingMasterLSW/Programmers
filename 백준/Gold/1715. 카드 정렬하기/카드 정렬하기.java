import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while (pq.size() > 1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            int value = min1 + min2;
            sum += value;
            pq.offer(value);
        } 
        
        System.out.println(sum);
    }
}