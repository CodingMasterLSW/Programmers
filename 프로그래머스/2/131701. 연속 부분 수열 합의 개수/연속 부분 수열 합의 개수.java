import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sets = new LinkedHashSet<>();

        for (int z = 1; z <= elements.length; z++) {

            for (int i = 0; i < elements.length; i++) {

                int addRes = 0;
                int idx = i;

                for (int j = 0; j < z; j++) {
                    idx = idx % elements.length;
                    addRes += elements[idx];
                    idx++;
                }
                sets.add(addRes);

            }
        }
        /*
        List<Integer> lists = new ArrayList<>(sets);
        
        Collections.sort(lists);
        for (Integer list : lists) {
            System.out.println(list);
        }
        */
        
        return sets.size();
    }
}