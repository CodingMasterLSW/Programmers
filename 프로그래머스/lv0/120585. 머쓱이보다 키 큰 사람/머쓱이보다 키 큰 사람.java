class Solution {
    public int solution(int[] array, int height){
        int result = 0;
        for(int i : array){
            result += (i>height) ? 1 : 0;
            } return result; 
        }
    
}