import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        Stack<Integer> s  = new Stack<>();

        for(int k : arr){
            if(s.isEmpty()){
                s.push(k);
            } else{
                if(s.peek()==k){
                    continue;
                }
                else{
                    s.push(k);
                }
            }

        }

        // 스택에는 [1,3,0,1] 들어있음
        int[] answer = new int[s.size()];

        for(int i=0; i<s.size(); i++){
            answer[i] = s.get(i);
        }

        return answer;
    }
}