import java.util.*;

class Solution {
    
    static int d;
    static int[] current;
    static int currentValue = 0;
    
    static int maxValue = 0;
    static int[] result;
        
    public int[] solution(int[][] dice) {
        d = dice.length / 2;
        current = new int[d];
        result = new int[d];
        
        backtracking(0, 1, dice);
        
        return result;
    }
    
    public void backtracking(int depth, int start, int[][] dice) {
        if (depth == d) {
            boolean[] used = new boolean[d * 2 + 1];
            
            for (int c : current) {
                used[c] = true;
            }
            
            List<Integer> sumA = new ArrayList<>();
            backtracking2(0, dice, current, sumA);
            
            int[] bDice = new int[d];
            int diceIdx = 0;
            
            for (int i=1; i<=d*2; i++) {
                if (!used[i]) {
                    bDice[diceIdx] = i;
                    diceIdx++;
                }
            }
            
            List<Integer> sumB = new ArrayList<>();
            backtracking2(0, dice, bDice, sumB);
            
            int cnt = count(sumA, sumB);
            if (cnt > maxValue) {
                maxValue = cnt;
                result = current.clone();
            }
            return;
        }
        
        for (int i=start; i<=d*2; i++) {
            current[depth] = i;
            backtracking(depth + 1, i+1, dice);
        }
    }
    
    public int count(List<Integer> diceA, List<Integer> diceB) {
        Collections.sort(diceB);
        
        int cnt = 0;
        for (int a : diceA) {
            
            int startIdx = 0;
            int endIdx = diceB.size();
            
            while(startIdx < endIdx) {
                int midIdx = (startIdx + endIdx) / 2;
                int middleValue = diceB.get(midIdx);

                if (a > middleValue) {
                    startIdx = midIdx + 1;
                } else if (a <= middleValue) {
                    endIdx = midIdx;
                }
            }
            cnt += startIdx;
        }
        return cnt;
    }
    
    
    
    public void backtracking2(int depth, int[][] dice, int[] diceArr, List<Integer> sum) {
        if (depth == d) {
            sum.add(currentValue);
            return;
        }
        int diceIdx = diceArr[depth] - 1; // 현재 주사위 Idx
        
        for (int i=0; i<6; i++) {
            currentValue += dice[diceIdx][i];
            backtracking2(depth + 1, dice, diceArr, sum);
            currentValue -= dice[diceIdx][i];
        }
    }
 
}