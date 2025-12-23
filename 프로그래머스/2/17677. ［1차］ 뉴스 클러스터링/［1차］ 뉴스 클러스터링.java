import java.util.*;

class Solution {
        
    public int solution(String str1, String str2) {
        Map<String, Integer> result1 = cal(str1);
        Map<String, Integer> result2 = cal(str2);
        
        if (result1.isEmpty() && result2.isEmpty()) {
            return 65536;
        }
        
        Set<String> arr = new HashSet<>();
        
        arr.addAll(result1.keySet());
        arr.addAll(result2.keySet());
                
        int x = 0;
        int y = 0;
        
        for(String a : arr) {
            x += Math.min(result1.getOrDefault(a, 0), result2.getOrDefault(a, 0));
            y += Math.max(result1.getOrDefault(a, 0), result2.getOrDefault(a, 0));
        }
    
        return (int)(((double) x / y) * 65536);
    
    }
    
    private Map<String, Integer> cal(String str) {
        String lowerStr = str.toLowerCase();
        Map<String, Integer> tmp = new HashMap<>();
        
        for (int i=0; i<lowerStr.length() -1; i++) {
            StringBuilder sb = new StringBuilder();
            
            char a = lowerStr.charAt(i);
            char b = lowerStr.charAt(i+1);
            
            if (isValid(a) && isValid(b)) {
                sb.append(a).append(b);
                tmp.put(sb.toString(), tmp.getOrDefault(sb.toString(), 0) + 1);
            }
        }
        return tmp;
        
    }
    
    private boolean isValid(char c) {
        return 'a' <= c && c <= 'z';
    }
}