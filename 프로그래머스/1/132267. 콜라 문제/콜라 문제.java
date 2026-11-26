// 빈 병 a 개 -> 콜라 b병을 줌 
// 빈 병 n 개를 가져다주면 몇 병을 받을 수 있는가? 


class Solution {
    public int solution(int a, int b, int n) {
        
        int result = 0;
        while(n/a > 0) {
            int r = n / a;
            int l = n % a;
            result += r * b;
            n = (n / a) * b;
            n += l;
        }
        
        return result;
    }
}