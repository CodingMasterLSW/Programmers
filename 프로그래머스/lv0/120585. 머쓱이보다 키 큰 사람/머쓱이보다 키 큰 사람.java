import java.util.*;
class Solution {
    public int solution (int[] array, int height){
        int result = 0;
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++) {
            if (height< array[array.length -i -1]){
                result++;
            } else {
                break;
            }
        } return result;
    }
}