import java.util.*;

class Solution {
    
    static int maxSum = -1;
    static int currentSum = 0;
    static int[] resultArr;
    static int[] tmpArr;
    
    public int[] solution(int n, int[] info) {
        resultArr = new int[info.length];
        tmpArr = new int[info.length];
        backtracking(0, n, info);
        
        if (maxSum == 0 || maxSum == -1) {
            return new int[]{-1};
        }
        return resultArr;
    }
    
    private void backtracking(int start, int leftAmount, int[] info) {
        if (start == 11) {
            // 0점에 몰아주기
            tmpArr[10] += leftAmount;
            calculate(info);
            tmpArr[10] -= leftAmount;
            return;
        }
        
        //선택지 1: 라이언이 해당 점수(start)를 가져가는 경우
        if (leftAmount >= info[start] + 1) {
            tmpArr[start] = info[start] + 1;
            backtracking(start + 1, leftAmount - tmpArr[start], info);
            tmpArr[start] = 0;
        }
        
        //라이언이 해당 점수(start)를 포기하는 경우 (0발 쏨)
        backtracking(start + 1, leftAmount, info);
    }
    
    private void calculate(int[] info) {
        int ryanScore = 0;
        int apeachScore = 0;
        
        for (int i=0; i<=10; i++) {
            if (info[i] == 0 && tmpArr[i] == 0) {
                continue;
            }
            if (info[i] > tmpArr[i]) {
                apeachScore += 10 - i;
            } else {
                ryanScore += 10 - i;
            }
        }
        
        int diff = ryanScore - apeachScore;
        if (diff > 0) {
            if (diff > maxSum) {
                maxSum = diff;
                resultArr = tmpArr.clone();
            } else if (diff == maxSum) {
                if (isBetter()) {
                    resultArr = tmpArr.clone();
                }
            }  
        }
    }
    
    private boolean isBetter() {
        for (int i = 10; i >= 0; i--) {
            if (tmpArr[i] > resultArr[i]) return true;
            if (tmpArr[i] < resultArr[i]) return false;
        }
        return false;
    }
}