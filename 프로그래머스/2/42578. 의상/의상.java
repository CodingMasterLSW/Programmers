import java.util.*;

class Solution {
   public static int solution(String[][] clothes) {

        Map<String, Integer> cloth = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            // System.out.println(clothes[i][1]);
            cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1], 0)+1);
        }
        int result = 1;
        for (Map.Entry<String, Integer> entry : cloth.entrySet()) {
            result *= (entry.getValue() + 1); // 각 종류별로 선택하지 않는 경우를 포함
        }

        return result -1;

    }
    
    
}