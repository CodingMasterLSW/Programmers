import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scores = new HashMap<>();
        
        for (int i=0; i<name.length; i++) {
            scores.put (name[i], yearning[i]);
        }
        System.out.println(scores.toString());
        
        int[] result = new int[photo.length];
        
        for (int i=0; i<photo.length; i++) {
            int sum = 0;
            for (String p : photo[i]) {
                if (scores.get(p) == null) {
                    continue;
                }
                sum += scores.get(p);
            }  
            result[i] = sum;
        }
        
        return result;
    }
}