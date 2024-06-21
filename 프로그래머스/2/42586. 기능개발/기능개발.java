import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        // List<Integer> lists = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int cal = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            q.add(cal);
        }

        List<Integer> lists = new ArrayList<>();

        int cnt = 1;
        int start = q.poll();

        while(!q.isEmpty()){
            if(q.peek()<=start){
                q.poll();
                cnt++;
                if(q.isEmpty()){
                    lists.add(cnt);
                }
            }
            else{
                lists.add(cnt);
                start = q.peek();
                cnt = 0;
            }
        }
        if(!q.isEmpty()){
            cnt+=q.size();
            lists.add(cnt);
        }
        int[] result = new int[lists.size()];
        for(int i=0; i<lists.size(); i++) {
            result[i] = lists.get(i);
        }
        return result;

    }
}