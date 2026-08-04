import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
       
        Map<String, Integer> result = new HashMap<>();
        Map<Integer, String> memory = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            result.put(players[i], i);
            memory.put(i, players[i]);
        }
        
        for (String call : callings) {
            // 앞사람을 먼저 뒤로 뺴야함 
            String frontUser = memory.get((result.get(call) -1));
            result.put(frontUser, result.get(frontUser)+1);
            memory.put(result.get(frontUser), frontUser);
            
            result.put(call, result.get(call) - 1);
            memory.put(result.get(call), call);
        }
        
        String[] fr = new String[players.length];
        
        for (int i=0; i<fr.length; i++) {
            fr[i] = memory.get(i);
        }
        
        return fr;
    }
}