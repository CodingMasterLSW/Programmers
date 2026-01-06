class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] sum = new int[n+1][m+1];
        
        for (int[] current : skill) {
            int type = current[0];
            int x1 = current[1];
            int y1 = current[2];
            int x2 = current[3];
            int y2 = current[4];
            int degree = current[5];
            
            if (type == 1) {
                // 파괴 구현
                sum[x1][y1] += -degree;
                sum[x1][y2+1] += degree;
                sum[x2+1][y1] += degree;
                sum[x2+1][y2+1] += -degree;
                
            } else {
                // 회복 구현
                sum[x1][y1] += degree;
                sum[x1][y2+1] += -degree;
                sum[x2+1][y1] += -degree;
                sum[x2+1][y2+1] += degree;
            }
        }
        
        // 가로 누적합 계산
        for (int i=0; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                sum[i][j] += sum[i][j-1];
            }
        }
        
        // 세로 누적합 계산
        for (int j=0; j<m+1; j++) {
            for (int i=1; i<n+1; i++) {
                sum[i][j] += sum[i-1][j];
            }
        }
        
        
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] + sum[i][j] >= 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}