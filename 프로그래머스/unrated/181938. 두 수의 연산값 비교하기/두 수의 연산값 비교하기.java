class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String c = String.valueOf(a) + String.valueOf(b);
        Integer d = Integer.parseInt(c);
        
        int result = 2*a*b;
        
        
        return Math.max(d, result);
    }
}