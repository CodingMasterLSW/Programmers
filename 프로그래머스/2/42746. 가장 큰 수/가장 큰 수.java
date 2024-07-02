import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, (a,b) -> {
            String st1 = a+b;
            String st2 = b+a;
            
            return st2.compareTo(st1);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : strNumbers){
            sb.append(str);
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}