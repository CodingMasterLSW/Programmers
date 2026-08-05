import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> history = new HashMap<>();
        int[] result = new int[s.length()];
        
        for (int i=0; i<s.length(); i++) {
            if (history.get(s.charAt(i)) == null) {
                history.put(s.charAt(i), i);
                result[i] = -1;
            } else {
                char c = s.charAt(i);
                result[i] = i - history.get(c);
                history.put(c, i);
            }
        }

        return result;
    }
}