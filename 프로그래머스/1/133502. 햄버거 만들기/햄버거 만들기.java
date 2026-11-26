import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Deque<Integer> deq = new ArrayDeque<>();
        int result = 0;
        for (int i=0; i<ingredient.length; i++) {
            deq.push(ingredient[i]);
            if (deq.size() < 4) {
                continue;
            }
            
            int a = deq.poll();
            int b = deq.poll();
            int c = deq.poll();
            int d = deq.poll();
            
            if (a == 1 && b == 3 && c == 2 && d == 1) {
                result += 1;
            } else {
                deq.push(d);
                deq.push(c);
                deq.push(b);
                deq.push(a);
            }
        }
        return result;
    }
}