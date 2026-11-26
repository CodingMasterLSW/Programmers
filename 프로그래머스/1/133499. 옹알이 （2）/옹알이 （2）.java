// 숫자로 치환 후 counting , 중복되서 오는 숫자가 있다면 noCount

class Solution {
    public int solution(String[] babbling) {
        int result = 0;
        for (String b : babbling) {
            String s = b.replaceAll("aya", "1")
                .replaceAll("ye", "2")
                .replaceAll("woo", "3")
                .replaceAll("ma", "4");
            
            if (check(s)) {
                result++;
            } 
        }
     
        return result;
    }
    
    public boolean check(String s) {
        char lastValue = '?';
        for (int i=0; i<s.length(); i++) {
            if (!isTarget(s.charAt(i))) {
                return false;
            }
            
            if (lastValue == s.charAt(i)) {
                return false;
            }
            lastValue = s.charAt(i);
        } 
        return true;
    }

    
    public boolean isTarget(char i){
        if (i == '1' || i == '2' || i == '3' || i == '4') {
            return true;
        }
        return false;
    }
}