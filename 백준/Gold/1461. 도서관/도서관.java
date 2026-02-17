import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (target > 0) {
                maxHeap.add(target);
            } else {
                minHeap.add(target);
            }
        }

        List<Integer> histories = new ArrayList<>();

        while(maxHeap.size() >= M) {
            histories.add(maxHeap.poll() * 2);

            for (int i=0; i<M-1; i++) {
                maxHeap.poll();
            }
        }

        int leftSum = 0;
        if (!maxHeap.isEmpty()) {
            leftSum += maxHeap.poll() * 2;
            histories.add(Math.abs(leftSum));
        }

        while(minHeap.size() >= M) {
            histories.add(Math.abs((minHeap.poll() * 2)));

            for (int i=0; i<M-1; i++) {
                minHeap.poll();
            }
        }

        int leftSum2 = 0;

        if (!minHeap.isEmpty()) {
            leftSum2 += minHeap.poll() * 2;
            histories.add(Math.abs(leftSum2));
        }

        Collections.sort(histories, Collections.reverseOrder());

        int result = 0;

        for (int history : histories) {
            result += history;
        }
        System.out.println(result - histories.get(0) / 2);
       
    }
}