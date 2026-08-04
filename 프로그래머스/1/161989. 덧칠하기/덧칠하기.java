import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int[] arr = new int[n+1];
        
        for (int s : section) {
            arr[s] = s;
        }
        
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            //System.out.println(i + "번째 탐색");
            if (arr[i] != 0) {
                for (int j=i; j <i+m; j++) {
                    if (j > n || arr[j] == 0) {
                        continue;
                    }
                    //System.out.println(arr[j] + "칠하기");
                    arr[j] = 0;
                }
                cnt++;
            }
        }
        
        return cnt;
    }
}