class Solution {
    public int solution(int n) {
        int current = 1;
        int sum = 0;
        
        while (current <= n) {
            if ((n % current) == 0) {
                sum += current;
            }
            current ++;
        }        
        return sum;
    }
}