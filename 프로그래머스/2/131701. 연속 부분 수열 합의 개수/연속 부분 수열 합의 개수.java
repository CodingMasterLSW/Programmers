import java.util.*;

class Solution {
    
     public int solution(int[] elements) {
        Set<Integer> sets = new LinkedHashSet<>();

        for (int z = 1; z <= elements.length; z++) {

            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < z+i; j++) {
                    sum += elements[j%elements.length];
                }
                sets.add(sum);
            }
        }
        return sets.size();
    
     }
}