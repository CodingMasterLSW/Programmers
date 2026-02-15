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
        maxHeap.offer(first);
        sb.append(first).append("\n");

        for (int i=2; i<=N; i++) {
            int current = Integer.parseInt(br.readLine());

            if (maxHeap.peek() < current) {
                minHeap.offer(current);
            } else {
                maxHeap.offer(current);
            }
            // 큐 크기 조절하기
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}