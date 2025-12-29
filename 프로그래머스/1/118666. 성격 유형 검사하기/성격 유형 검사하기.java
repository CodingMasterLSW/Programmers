import java.util.*;

class Solution {
    
    private static Map<Character, Integer> result = new HashMap<>();
    private static Set<Character> personalities = 
        Set.of('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N');
    private static Set<Integer> positive = Set.of(5, 6, 7);
    private static Set<Integer> negative = Set.of(1, 2, 3);
    private static List<String> types = List.of("RT", "CF", "JM", "AN");

    public String solution(String[] survey, int[] choices) {
        init();
        
        for (int i=0; i<survey.length; i++) {
            String s = survey[i];
            char disagree = s.charAt(0);
            char agree = s.charAt(1);
            
            int choice = choices[i];
            
            if (positive.contains(choice)) {
                calculate(agree, choice);
            }
            
            if (negative.contains(choice)) {
                calculate(disagree, choice);
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        
        for (String type : types) {
            char first = type.charAt(0);
            char second = type.charAt(1);
            
            int firstValue = result.get(first);
            int secondValue = result.get(second);
            
            if (firstValue > secondValue) {
                sb.append(first);
                continue;
            }
            if (firstValue < secondValue) {
                sb.append(second);
                continue;
            }
            
            if (first < second) {
                sb.append(first);
            } else {
                sb.append(second);
            }
        }
        return sb.toString();
    }
    
    private void init() {
        for (Character c : personalities) {
            result.put(c, 0);
        }
    }
    
    private void calculate(char p, int choice) {
        if (choice == 1) {
            result.put(p, result.get(p) + 3);
            return;
        }
        if (choice == 2) {
            result.put(p, result.get(p) + 2);
            return;
        }
        if (choice == 3) {
            result.put(p, result.get(p) + 1);
            return;
        }
        
        if (choice == 4) {
            return;
        }
        if (choice == 5) {
            result.put(p, result.get(p) + 1);
            return;
        }
        
        if (choice == 6) {
            result.put(p, result.get(p) + 2);
            return;
        }
        
        if (choice == 7) {
            result.put(p, result.get(p) + 3);
            return;
        }
    }
}