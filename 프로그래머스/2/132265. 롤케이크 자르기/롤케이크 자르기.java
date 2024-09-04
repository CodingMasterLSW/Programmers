import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            map1.put(topping[i], map1.getOrDefault(topping[i], 0)+1);
        }
        int res = 0;
        
        for(int j=0; j<topping.length; j++){
            
            map1.put(topping[j], map1.get(topping[j]) -1 );
            
            if(map1.get(topping[j]) == 0){
                map1.remove(topping[j]);
            }
            
            map2.put(topping[j], 0);
            if(map1.size() == map2.size()){
                res++;
            }
            
        }
    
        return res;
    }
}