import java.util.*;
class Solution {
    public int[] solution(long n) {
        List<Long> arr = new ArrayList<>();
        
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }        
        return arr.stream().mapToInt(Long::intValue).toArray();
    }
}