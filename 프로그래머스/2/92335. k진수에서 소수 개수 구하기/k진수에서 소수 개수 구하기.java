class Solution {
    public int solution(int n, int k) {
        String a = Integer.toString(n, k);
        
        int startIdx = 0;
        int endIdx = 0;
        int cnt = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (endIdx < a.length()) {            
            if (a.charAt(endIdx) != '0') {
                sb.append(a.charAt(endIdx));                
            } else {
                if (sb.toString().length() > 0) {
                    if (isPrime(Long.parseLong(sb.toString()))) {
                        cnt++;
                    }
                    sb.setLength(0);
                }
            }
            endIdx++;
            startIdx = endIdx;
        }

        if (sb.toString().length() > 0) {
            if (isPrime(Long.parseLong(sb.toString()))){
                cnt++;
            }
        }
        return cnt;
    }
    
    private boolean isPrime(long target) {
        if (target == 1) {
            return false;
        } 
        
        if (target == 2) {
            return true;
        }
        
        if (target % 2 == 0) {
            return false;
        }
        
        for (long i = 3; i * i <= target; i += 2) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
        
    }
}