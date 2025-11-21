import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> maps = new HashMap<>();
        init(maps);
        String newS = s.toLowerCase();
        
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (int i=0; i<newS.length(); i++) {
            String tmp = String.valueOf(newS.charAt(i));
            current.append(tmp);
            if (maps.get(current.toString()) != null) {
                result.append(maps.get(current.toString()));
                current.setLength(0);
            } 
        }
        return Integer.parseInt(result.toString());
                
    }
    
    public static void init(Map<String, String> maps) {
        maps.put("0", "0");
        maps.put("1", "1");
        maps.put("2", "2");
        maps.put("3", "3");
        maps.put("4", "4");
        maps.put("5", "5");
        maps.put("6", "6");
        maps.put("7", "7");
        maps.put("8", "8");
        maps.put("9", "9");
        
        maps.put("zero", "0");
        maps.put("one", "1");
        maps.put("two", "2");
        maps.put("three", "3");
        maps.put("four", "4");
        maps.put("five", "5");
        maps.put("six", "6");
        maps.put("seven", "7");
        maps.put("eight", "8");
        maps.put("nine", "9");
    }
}