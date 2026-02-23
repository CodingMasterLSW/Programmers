// 1. nCn/2 완탐 
// 2. 1번의 결과에 대한 모든 경우의 수 완탐
// 3. 이분탐색 / two-pointer로 경우의 수 줄이기

import java.util.*; 

class Solution {
    
    static int d;
    static int[] current;
    static int maxValue = 0;
    static int[] maxResult;
    
    public int[] solution(int[][] dice) {
        d = dice.length/2;
        current = new int[d];
        maxResult = new int[d];
        
        backtracking(0, 1, dice);
        return maxResult;
    }
    
    public void backtracking(int depth, int start, int[][] dice) {
        if (depth == d) {
            findCombination(dice);            
            return;
        }
        
        for (int i=start; i<=d*2; i++) {
            current[depth] = i;
            backtracking(depth+1, i+1, dice);
        }
    }
    
    public void findCombination(int[][] dice) {
        int[] b = findB();
        // A의 합 배열 구하기 ex 1, 2
        List<Integer> aSum = new ArrayList<>();
        List<Integer> bSum = new ArrayList<>();
        
        // B의 합 배열 구하기 ex 3, 4
        
        calSum(0, aSum, current, dice, 0);
        calSum(0, bSum, b, dice, 0);
        
        int amount = calAmount(aSum, bSum);
        if (amount > maxValue) {
            maxValue = amount;
            maxResult = current.clone();
        }
    }
    
    public int calAmount(List<Integer> aSum, List<Integer> bSum) {
        Collections.sort(bSum);
        int cnt = 0;
        for (int a : aSum) {
            int start = 0;
            int end = bSum.size();
            while(start < end) {
                int mid = (start + end) / 2;
                int value = bSum.get(mid);
                
                if (a > value) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            cnt += start;
        }
        return cnt;
    }
    
    public void calSum(int depth, List<Integer> arr, int[] target, int[][] dice, int sum) {
        if (depth == target.length) {
            arr.add(sum);
            return;
        }
        
        int currentDice = target[depth] - 1;
        for (int i=0; i<6; i++) {
            calSum(depth + 1, arr, target, dice, sum + dice[currentDice][i]);
        }
        
    }
   
    
    public int[] findB() {
        boolean[] visited = new boolean[d*2+1];
        for (int c : current) {
            visited[c] = true;
        }
        
        int[] b = new int[d];
        int idx = 0;
        for (int i=1; i<=d*2; i++) {
            if (!visited[i]) {
                b[idx] = i;
                idx++;
            }
        }
        return b;
    }
    
}