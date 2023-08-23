import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list){
        int n = num_list.length;
        int [] result = new int[n];
        
        for(int i=n-1; i>=0; i--){
            result[n-1-i] = num_list[i];
        } 
        return result;
    }
}