class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = numbers[i]*2;
        } return result;
    }
}