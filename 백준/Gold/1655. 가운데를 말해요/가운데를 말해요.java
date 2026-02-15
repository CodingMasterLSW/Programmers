import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        
        int first = Integer.parseInt(br.readLine());
        minHeap.offer(first);
        sb.append(first).append("\n");

        for (int i=2; i<=N; i++) {
            int current = Integer.parseInt(br.readLine());

            if (minHeap.peek() <= current) {
                minHeap.offer(current);
            } else {
                maxHeap.offer(current);
            }
            // 큐 크기 조절하기
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }

            if (i%2 == 0) {
                sb.append(maxHeap.peek()).append("\n");
            } else {
                sb.append(minHeap.peek()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}