import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        Queue<int[]> que = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            que.offer(new int[]{priorities[i], i});
        }

        int result = 0;
        while(!que.isEmpty()){
            boolean isMax = true;
            int[] current = que.poll();

            for(int[] q : que){
                if(q[0]>current[0]){
                    isMax = false;
                    break;
                }
            }

            if(!isMax){
                que.offer(current);
            } else{
                result++;
                if(location == current[1]){
                    System.out.println(result);
                    return result;
                }
            }

        }
        return result;
    }
    
}