import java.util.*;

class Solution {
    public static int[] solution(int[] prices) {

        Queue<Integer> q = new LinkedList<>();
        for(int que : prices){
            q.offer(que);
        }

        int index = 0;
        int[] answer = new int[prices.length];
        while(!q.isEmpty()){

            int result = 0;
            int current = q.poll();

            for(int que : q){
                result++;
                if(current<=que){
                    continue;
                } else{
                    break;
                }

            }
            answer[index] = result;
            index++;

            if(q.size()<=1){
                answer[index] = 0;
                break;
            }

        }


        return answer;
    }
}