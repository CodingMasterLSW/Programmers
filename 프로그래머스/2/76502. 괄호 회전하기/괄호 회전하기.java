import java.util.*;

class Solution {
    public int solution(String s) {
        
        int cnt = 0;
        
        if(isTrue(s)){
            cnt++;
        }
        String newString = s;
        
        for(int i=0; i<s.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(newString);
            sb.append(newString.charAt(0));
            sb.deleteCharAt(0);
            
            newString = sb.toString();
            if(isTrue(newString)){
                cnt++;
            }
        }
        return cnt;
    }
    public static boolean isTrue(String s){
        Stack<Character> stacks = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stacks.add(s.charAt(i));
            } else{
                if(stacks.isEmpty()){
                    return false;
                }
                char c = stacks.peek();
                if(c=='(' && s.charAt(i) == ')'){
                    stacks.pop();
                } else if (c=='{' && s.charAt(i) == '}'){
                    stacks.pop();
                } else if(c=='[' && s.charAt(i) == ']'){
                    stacks.pop();
                }
            }
        }
        if(stacks.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
}