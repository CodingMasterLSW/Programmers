import java.util.*;
class Solution{
    public static int solution(String s){

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            } else{
                if(s.charAt(i)==stack.peek()){
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }

        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        solution("baabaa");
    }
        
  
  
}