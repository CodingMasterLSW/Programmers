class Solution {
    
    static String[][] graph = new String[8][8];
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    
    // h = 행(row) , w = 열(column)
    public int solution(String[][] board, int h, int w) {
        for (int i=0; i<board.length; i++) {
            String[] b = board[i];
            for (int j=0; j<b.length; j++) {
                graph[i][j] = board[i][j];
            }
        }
        
        int cnt = 0;
        
        for (int i=0; i<4; i++) {
            int nrow = drow[i] + h;
            int ncol = dcol[i] + w;
            
            if (nrow < 0 || nrow >= 7 || ncol < 0 || ncol >= 7) {
                continue;
            }
            
            if (graph[nrow][ncol] == null) {
                continue;
            }
            
            if (graph[nrow][ncol].equals(graph[h][w])) {
                cnt ++;
            }
        }
        return cnt;
    }
}