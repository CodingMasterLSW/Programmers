import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();
        Queue<String> target = new ArrayDeque<>();
        
        for (String card : cards1) {
            q1.offer(card);
        }
        
        for (String card : cards2) {
            q2.offer(card);
        }
        
        for (String g : goal) {
            target.offer(g);
        }
        
        boolean status = false;
        
        while(true) {
            if (target.isEmpty()) {
                status = true;
                break;
            }
            
            String t = target.poll();
            if (!q1.isEmpty() && q1.peek().equals(t)) {
                q1.poll();
            } else if (!q2.isEmpty() && q2.peek().equals(t)) {
                 q2.poll();
            } else {
                break;
            }
        }
        if (status) {
            return "Yes";
        } else{
            return "No";
        }
    }
}