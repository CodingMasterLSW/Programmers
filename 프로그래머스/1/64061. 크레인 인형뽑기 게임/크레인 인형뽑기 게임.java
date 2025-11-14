import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // for (int i=0; i<board.length; i++) {
        //     for (int j=0; j<board.length; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        Deque<Integer> q = new ArrayDeque<>();
        int count = 0;
        
        for (int i=0; i<moves.length; i++) {
            int target = moves[i] - 1;
            
            for (int j=0; j<board.length; j++) {  
                if (board[j][target] == 0) {
                    continue;
                } else {
                    q.addFirst(board[j][target]);
                    board[j][target] = 0;
                    break;
                }
            }
            if (q.isEmpty() || q.size() == 1) {
                continue;
            } else {
                int firstNum = q.poll();
                int secondNum = q.poll();            
                if (firstNum == secondNum) {
                    count+=2;
                } else {
                    q.addFirst(secondNum);
                    q.addFirst(firstNum);
                }
            }
        }
        return count;
    }
}