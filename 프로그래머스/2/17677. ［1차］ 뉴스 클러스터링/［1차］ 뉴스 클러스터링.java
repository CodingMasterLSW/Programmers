import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        Map<String, Integer> cal1 = calculate(str1);
        Map<String, Integer> cal2 = calculate(str2);
                
        if (cal1.size() == 0 && cal2.size() == 0) {
            return 65536;
        }
        
        Set<String> all = new HashSet<>();
        
        all.addAll(cal1.keySet());
        all.addAll(cal2.keySet());
        
        int intersaction = 0;
        int union = 0;
        for (String a : all) {
            int x = cal1.getOrDefault(a, 0);
            int y = cal2.getOrDefault(a, 0);
            
            intersaction += Math.min(x, y);
            union += Math.max(x, y);
        }
    
        int value = (int) (((double) intersaction / union) * 65536);
        return value;
    }
    
    private Map<String, Integer> calculate(String str) {
        String lowerStr = str.toLowerCase();
        Map<String,Integer> group = new HashMap<>();
    
        for (int i=0; i<str.length()-1; i++) {
            StringBuilder sb = new StringBuilder();
            char a = lowerStr.charAt(i);
            char b = lowerStr.charAt(i+1);
            if (isValid(a) && isValid(b)) {
                sb.append(a).append(b);
                String key = sb.toString();
                group.put(key, group.getOrDefault(key, 0) + 1);
            }
        }        
        return group;
    }
    
    private boolean isValid(char c) {
        if ('a' <= c && c <= 'z') {
            return true;
        }
        return false;
    }
}