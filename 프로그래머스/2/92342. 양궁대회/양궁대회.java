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
            tmpArr[10] += leftAmount;
            calculate(info);
            tmpArr[10] -= leftAmount;
            return;
        }

        for (int i=start; i<info.length; i++) {
            if (leftAmount <= info[i]) {
                continue;
            }
            leftAmount -= info[i] + 1;
            tmpArr[i] = info[i] + 1;
            currentSum += 10 - i;
            backtracking(i+1, leftAmount, info);
            
            leftAmount += info[i] + 1;
            currentSum -= 10 - i; 
            tmpArr[i] = 0;
        }
        backtracking(11, leftAmount, info);
    }
    
    private void calculate(int[] info) {
        int ryanScore = 0;
        int apeachScore = 0;

        // 1. 라이언과 어피치의 최종 점수 계산
        for (int i = 0; i <= 10; i++) {
            if (info[i] == 0 && tmpArr[i] == 0) continue; // 둘 다 0발이면 점수 없음

            if (tmpArr[i] > info[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }

        int diff = ryanScore - apeachScore;

        if (diff > 0) {
            if (diff > maxSum) {
                maxSum = diff;
                resultArr = tmpArr.clone(); 
            } 
            else if (diff == maxSum) {
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