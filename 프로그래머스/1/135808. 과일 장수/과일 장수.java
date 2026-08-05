// 가장 품질이 안 좋은 사과가 가격의 기준임
// 비싼 사과부터 스코어 계산하기
// 1) 사과 정렬 , 2) 순서대로 없애기 

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        if (m > score.length) {
            return 0;
        }
        
        Arrays.sort(score);
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=score.length-1; i>=0; i--) {
            q.offer(score[i]);
        }
        
        int result = 0;

        while(q.size() >= m) {
            int lastScore = 0;
            for (int i=0; i<m; i++) {
                lastScore = q.poll();
                //System.out.print(lastScore + " ");
            }
            //System.out.println();
            int value = Math.min(lastScore, k);
            //System.out.println(value * m);
            result += value * m;
        }
        
        return result;
    }
}