import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> lists = new ArrayList<>();
        int[] num = new int[commands.length];
        int idx = 0;
        for(int i=0; i<commands.length; i++){

            for(int j= commands[i][0]-1; j<commands[i][1]; j++){
                lists.add(array[j]);
        
            }
            Collections.sort(lists);
            
            num[idx] = lists.get(commands[i][2]-1);
            idx++;
            lists.clear();
        
        }
        return num;
    }
}