import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> maps = new HashMap<>();
        for(int i=0; i<want.length; i++){
            maps.put(want[i], number[i]);
        }
        // 수량 총 개수 구하기
        int numLength = 0;
        for(String s : maps.keySet()){
            numLength += maps.get(s);
        }
        int startCnt = discount.length - numLength;
        int cnt = 0;
        int idx = 0;
        for(int i = 0; i<=startCnt; i++){
        
            Map<String, Integer> tempMap = new HashMap<>();
            int tmp = startCnt;
            
            for(int j=idx; j<numLength+idx; j++){
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0) +1);
            }
            boolean status = true;
            for(String s : maps.keySet()){
                if(maps.get(s) != tempMap.get(s)){
                    status = false;
                }
            }
            if(status){
                cnt++;
            }
            idx++;
        }
        
        return cnt;
    }
}