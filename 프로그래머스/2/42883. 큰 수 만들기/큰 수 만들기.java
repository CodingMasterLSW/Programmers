import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        
        for (int i=0; i<len; i++){
            char c = number.charAt(i);
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;  // 숫자를 하나 제거했으므로 k 감소
            }
            stack.push(c);
            
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }
}