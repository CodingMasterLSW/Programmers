// 2) Map에 넣은 후 iterater 풀이

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Integer, Integer> xs = new HashMap<>();
        Map<Integer, Integer> ys = new HashMap<>();
        
        for (int i=0; i<X.length(); i++) {
            int c = X.charAt(i) - '0';
            xs.put(c, xs.getOrDefault(c, 0) + 1);
        }
        
         for (int i=0; i<Y.length(); i++) {
             int c = Y.charAt(i) - '0';
             ys.put(c, ys.getOrDefault(c, 0) + 1);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; i--) {
            if (xs.get(i) == null || ys.get(i) == null) {
                continue;
            }
            int v = Math.min(xs.get(i), ys.get(i));
            for (int j=0; j<v; j++) {
                sb.append(i);
            }
        }
        
        if (sb.isEmpty()) {
            return "-1";
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}