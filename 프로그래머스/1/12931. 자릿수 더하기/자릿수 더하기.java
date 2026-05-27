import java.util.*;

public class Solution {
    public int solution(int n) {
        String s = String.valueOf(n);
        
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        
        return sum;
    }
}