import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        List<Integer> arr = new ArrayList<>();

        
        while (n > 0) {
            arr.add((int)(n % 10));
            n /= 10;
        }
        Collections.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (int a : arr) {
            sb.append(a);
        }
        
        return Long.parseLong(sb.toString());    
    }
}