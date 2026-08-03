// 짝수인 경우
// 홀수인 경우

import java.util.*;

class Solution {
    
    static int[][] graph = new int[102][11];
    
    public int solution(int n, int w, int num) {
        int cnt = 1;
        int currentDepth = 101;
        
        while(true) {
            // 짝수인 경우
            if (currentDepth % 2 == 0) {
                for (int i=w-1; i >= 0; i--) {
                    if (cnt > n) {
                        break;
                    }
                    graph[currentDepth][i] = cnt;
                    cnt++;
                }
            }
            if (cnt > n) {
                break;
            }
            
            // 홀수인 경우
            if (currentDepth % 2 != 0) {
                for (int i=0; i<w; i++) {
                    if (cnt > n) {
                        break;
                    }
                    graph[currentDepth][i] = cnt;
                    cnt++;
                }
            }
            if (cnt > n) {
                break;
            }
            currentDepth -=1;  
        }
        
        int[] targetStart = new int[]{0, 0};
        
        boolean status = false;
        for (int i=101; i>=0; i--) {
            for (int j=0; j<w; j++) {
                if (graph[i][j] == num) {
                    targetStart[0] = i;
                    targetStart[1] = j;
                    status = true;
                    break;
                }
            }
            if (status) {
                break;
            }
        }
        //System.out.println("targetStart = " + Arrays.toString(targetStart));
        
        int finalCnt = 0;
        int startColumn = targetStart[0];
        int startRow = targetStart[1];
        
        for (int i = startColumn; i >=0; i--) {
            if (graph[i][startRow] != 0) {
                finalCnt++;
            } else {
                break;
            }
                        
        }
        return finalCnt;
        
    }
}