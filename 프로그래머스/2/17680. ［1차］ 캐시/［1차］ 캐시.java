import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        Deque<String> deq = new ArrayDeque<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(String city : cities){
            String s = city.toLowerCase();
            if(deq.isEmpty()){
                deq.offer(s);
                time+=5;
                continue;
            }
            
            if(deq.contains(s)){
                deq.remove(s);
                deq.offer(s);
                time += 1;
            } else{
                if(deq.size() < cacheSize){
                    deq.offer(s);
                    time+=5;
                }
                else{
                    deq.poll();
                    deq.offer(s);
                    time += 5;
                }
            }
        }
        return time;
    }
}