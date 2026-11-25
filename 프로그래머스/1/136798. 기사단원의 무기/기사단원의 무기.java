// 일단 번호가 주어졌을 때, 약수의 개수를 반환하는 로직을 알아야함

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int result = 0;
        for (int i=1; i<=number; i++) {
            int v = count(i);
            if (v > limit) {
                result += power;
            } else {
                result += v;
            }
        }
        return result;
    }
    
    public int count(int number) {
        int cnt = 1;
        for (int i= 1; i < (number / 2) + 1; i++) {
            if(number % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}