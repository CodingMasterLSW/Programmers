import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> lists = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            lists.add(numbers[i]);
        }

        Collections.sort(lists, (a,b) -> {
            String st1 = String.valueOf(a) + String.valueOf(b);
            String st2 = String.valueOf(b) + String.valueOf(a);

            return Integer.parseInt(st2)-Integer.parseInt(st1);
        });
        
        
        
        StringBuilder sb = new StringBuilder();
        for(int list : lists){
            sb.append(list);
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}