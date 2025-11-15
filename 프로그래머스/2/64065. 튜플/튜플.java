import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] split = s.replaceAll("[{}]", " ").trim().split(" ,");
        
        Set<String> arr = new HashSet<>();
        
        Arrays.sort(split, (o1, o2) -> o1.length() - o2.length());
        
        int[] answer = new int[split.length];
        
        int idx = 0;
        
        for (int i=0; i<split.length; i++) {
            String[] split2 = split[i].split(",");
            for (int j=0; j<split2.length; j++) {
                String value = split2[j].trim();
                if (arr.add(value)) {
                    answer[idx] = Integer.parseInt(value);
                    idx++;
                    break;
                }
            }
        }
        return answer;
    }
}