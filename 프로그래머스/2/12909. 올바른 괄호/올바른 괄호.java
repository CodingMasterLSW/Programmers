import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        if(s.substring(0).equals(")")){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }
}