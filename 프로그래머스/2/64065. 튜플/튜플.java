import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        List<int[]> arr = new ArrayList<>();
        
        String[] newS = s.replaceAll("[{}]", " ").split(" ,");
        for (int i=0; i<newS.length; i++) {
            String[] split = newS[i].trim().split(",");    
            int[] nums = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                nums[j] = Integer.parseInt(split[j]);
            }
            arr.add(nums);
        }
        
        Collections.sort(arr, (o1, o2) -> o1.length - o2.length);
        
        List<Integer> result = new ArrayList<>();
        for (int[] a : arr) {
            for (int i=0; i<a.length; i++) {
                if (result.contains(a[i])) {
                    continue;
                } else {
                    result.add(a[i]);
                    break;
                }
            }
        }
        int[] finalResult = new int[result.size()];
        
        for (int i=0; i<result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        
        return finalResult;
    }
}