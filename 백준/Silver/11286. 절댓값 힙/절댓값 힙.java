import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a); // -2
            int absB = Math.abs(b); // 2

            if (absA - absB == 0) {
                return a - b;
            }
            return absA - absB;
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(minHeap.poll()).append("\n");
                continue;
            }

            minHeap.offer(current);
        }
        System.out.println(sb.toString());
    }
}

