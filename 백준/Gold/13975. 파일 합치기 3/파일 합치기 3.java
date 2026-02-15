import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j=0; j<k; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() > 1) {
                long min1 = pq.poll();
                long min2 = pq.poll();

                long value = min1 + min2;

                sum += value;

                pq.offer(value);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}