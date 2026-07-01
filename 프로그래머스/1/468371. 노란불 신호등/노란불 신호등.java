// 신호등은 N개임 
// 배열에다가 boolean 값을 넣고, 반복문으로 수행?

class Solution {    
    public int solution(int[][] signals) {
        boolean[][] result = new boolean[signals.length][4000005];
        
        for (int i=0; i<signals.length; i++) {
            int idx = 1;
            int green = signals[i][0];
            int yellow = signals[i][1];
            int red = signals[i][2];
            
            while (idx < 4000000) {
                for (int k=0; k<green && idx < 4000000; k++) {
                    result[i][idx] = false;
                    idx++;
                }
                for (int k=0; k<yellow && idx < 4000000; k++) {
                    result[i][idx] = true;
                    idx++;
                }
                for (int k=0; k<red && idx < 4000000; k++) {
                    result[i][idx] = false;
                    idx++;
                }
            }
        }

        // 3번 반복문을 돈다
        
        int minValue = -1;
        
        for (int i=1; i<=4000000; i++) {
            boolean isValue = true;

            for (int j=0; j<signals.length; j++) {
                if (result[j][i] != true) {
                    isValue = false;
                    break;
                } 
            }
            if (isValue) {
                minValue = i;
                break;
            }
        }
        
        return minValue;
    }
}