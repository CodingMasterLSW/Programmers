import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for (int i=0; i<queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long totalSum = sum1 + sum2;
        
        long target = totalSum / 2;
        
        int cnt = 0;
        
        // 종료 조건을 계산해야 하는데 흠...
        while(true) {
            if (sum1 == target) {
                break;
            }
            
            if (cnt > queue1.length * 4) {
                break;
            }
            
            if (sum1 > target) {
                int peekValue = q1.poll();
                sum1 -= peekValue;
                q2.offer(peekValue);
            } else if (sum1 < target) {
                int peekValue = q2.poll();
                sum1 += peekValue;
                q1.offer(peekValue);
            }
            cnt++;
        }
        
        if (cnt > queue1.length * 4) {
            return -1;
        }
        return cnt;
    }
}