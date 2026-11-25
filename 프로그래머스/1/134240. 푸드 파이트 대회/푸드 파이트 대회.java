// 전형적인 팰린드롬 문제 
// 칼로리가 낮은 음식 먼저 배치

import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i=1; i<food.length; i++) {
            int cnt = food[i] / 2;
            for (int j=0; j<cnt; j++) {
                deq.push(i);
                sb.append(i);
            }
        }
        
        sb.append(0);
        while(!deq.isEmpty()) {
            sb.append(deq.poll());
        }
        
    
        return sb.toString();
    }
}