import java.util.*;

class Solution {
    
    static int[][] result1;
    static int[][] result2;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        result1 = new int[n][n];
        result2 = new int[n][n];
        
        for (int i=0; i<arr1.length; i++) {
            result1[i] = change(n, arr1[i]);
        }
        
        for (int i=0; i<arr2.length; i++) {
            result2[i] = change(n, arr2[i]);
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (result1[i][j] == 0 && result2[i][j] != 0) {
                    result1[i][j] = 1;
                }
            }
        }
        
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (result1[i][j] == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
            
        return answer;
    }
    
    public static int[] change(int n, int value) {
        Deque<Integer> arr = new ArrayDeque<>();
        while (true) {
            int current = (value / 2);
            int leftValue = (value % 2);
            arr.push(leftValue);
            value = current;            
            if (current == 0) {
                break;
            }
        }
        
        int[] reverse = new int[n];
        int diff = n-arr.size();
        int count = 0;
        while (!arr.isEmpty()) {
            reverse[count+diff] = arr.pop();
            count++;
        }
        return reverse;
    }
}