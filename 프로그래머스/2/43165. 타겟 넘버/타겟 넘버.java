class Solution {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    
    public static void dfs(int[] numbers, int target, int idx, int currentSum){
        if(idx == numbers.length){
            if(currentSum == target){
                cnt++;
            }
            return;
        }
        
        dfs(numbers, target, idx+1, currentSum+numbers[idx]);
        dfs(numbers, target, idx+1, currentSum-numbers[idx]);
    }
    
}