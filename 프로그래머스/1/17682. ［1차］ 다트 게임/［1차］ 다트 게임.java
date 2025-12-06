import java.util.*;
class Solution {
    public int solution(String dartResult) {

        List<Character> num = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        
        List<String> splitResult = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<dartResult.length(); i++) {
            if (num.contains(dartResult.charAt(i))) {
                if (sb.length() != 0) {
                    splitResult.add(sb.toString());
                    sb.setLength(0);
                }
            }
            sb.append(dartResult.charAt(i));
            if (dartResult.charAt(i) == '1' && i + 1 < dartResult.length() && dartResult.charAt(i+1) == '0') {
                i++;  
                sb.append(dartResult.charAt(i)); 
    }
        }
        splitResult.add(sb.toString());
        
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        
        int idx = 0;
        
        for (String s : splitResult) {
            int currentResult = 0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (num.contains(c)) {
                    if (i < s.length() - 1 && c == '1' && s.charAt(i+1) == '0') {
                        currentResult += 10;
                        i++;
                    } else {
                        currentResult += Integer.parseInt(String.valueOf(c));
                    }
                }
                if (c == 'S') {
                    currentResult *= 1;
                }
                
                if (c == 'D') {
                    currentResult *= currentResult;
                }
                if (c == 'T') {
                    currentResult *= currentResult * currentResult;
                }
                
                if (c == '*') {
                    if (idx == 0) {
                        currentResult *= 2;
                    } else if (idx == 1){
                        currentResult *= 2;
                        result1 *= 2;
                    } else if (idx == 2) {
                        currentResult *= 2;
                        result2 *= 2;
                    }
                }
                if (c == '#') {
                    currentResult -= currentResult * 2;
                }

            }
            if (idx == 0) {
                result1 = currentResult;
            }
            if (idx == 1) {
                result2 = currentResult;
            }
            if (idx == 2) {
                result3 = currentResult;
            }
            idx++;
        }
        // System.out.println(result1);
        // System.out.println(result2);
        // System.out.println(result3);
  
        return result1 + result2 + result3;
    }
}