import java.util.*;

class Solution {

    public String solution(String s, String skip, int index) {
        
        List<Character> skips = new ArrayList<>();
        
        for (char c : skip.toCharArray()) {
            skips.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            char target = convert(skips, c, index);
            sb.append(target);
        }
        return sb.toString();
    }
    
    public static char convert(List<Character> skips, char c, int index) {
        int cnt = 1;
        int currentIdx = 0;
        char currentTarget = c;
        
        while (cnt <= index) {
            currentIdx++;
            char target = (char) ('a' + (c - 'a' + currentIdx) % 26);
    
            if (skips.contains(target)) {
                continue;
            } 
            cnt++;
            currentTarget = target;
        }
        return currentTarget;
    }
}