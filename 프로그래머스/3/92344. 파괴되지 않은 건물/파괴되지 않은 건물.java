// 파괴되었다가 복구 가능
// 공격은 직사각형 형태 -> bfs로 할 필요가 없어보임. 그냥 구현 아닌가
import java.util.*;

class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] copyBoard = new int[n+1][m+1];
        
        for (int[] current : skill) {
            int type = current[0];
            int x1 = current[1];
            int y1 = current[2];
            int x2 = current[3];
            int y2 = current[4];
            int degree = current[5];
            
            if (type == 1) {
                copyBoard[x1][y1] -= degree;
                copyBoard[x1][y2 + 1] += degree;
                copyBoard[x2 + 1][y1] += degree;
                copyBoard[x2 + 1][y2 + 1] -= degree;
            } else {
                copyBoard[x1][y1] += degree;
                copyBoard[x1][y2 + 1] -= degree;
                copyBoard[x2 + 1][y1] -= degree;
                copyBoard[x2 + 1][y2 + 1] += degree;
            }
        }
        
        for (int i=0; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                copyBoard[i][j] += copyBoard[i][j-1];
            }
        }
        
        for (int j=0; j<=m; j++) {
            for (int i=1; i<=n; i++) {
                copyBoard[i][j] += copyBoard[i-1][j];
            }
        }
     
        
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] + copyBoard[i][j] >= 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}