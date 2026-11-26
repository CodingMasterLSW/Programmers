import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for (int i=0; i<sizes.length; i++) {
            int[] arr = sizes[i];
            System.out.println(Arrays.toString(arr));
            if (arr[0] >= arr[1]) {
                max = Math.max(max , arr[0]);
                min = Math.max(min, arr[1]);
            } else {
                max = Math.max(max, arr[1]);
                min = Math.max(min, arr[0]);
            }
        }
        return max * min;
    }
}