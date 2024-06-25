import java.util.*;

class Solution {
   public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int node : scoville) {
            minHeap.add(node);
        }

        int answer = 0;
        while (minHeap.size() > 1) {
            if (minHeap.peek() >= K) {
                return answer;
            }

            int firstNode = minHeap.poll();
            int secondNode = minHeap.poll();
            int newNode = firstNode + (secondNode * 2);
            minHeap.add(newNode);
            answer++;
        }

        // 마지막 하나 남은 요소가 K 이상인지 확인
        if (minHeap.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}