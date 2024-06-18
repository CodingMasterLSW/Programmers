import java.util.*;

class Solution {
    public static int solution(int[] nums) {

        Set<Integer> sets = new HashSet<>();

        for(int i : nums){
            sets.add(i);
        }

        int count = nums.length/2;

        if(sets.size()<=count){
            System.out.println(sets.size());
            return sets.size();
        }
        System.out.println(count);
        return count;


    }
}