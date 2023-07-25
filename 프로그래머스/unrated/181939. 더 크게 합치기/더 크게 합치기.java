class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String c = String.valueOf(a) + String.valueOf(b);
        String d = String.valueOf(b) + String.valueOf(a);
        
        Integer intC = Integer.parseInt(c);
        Integer intD = Integer.parseInt(d);
            
        return Math.max(intC, intD);
    }
}