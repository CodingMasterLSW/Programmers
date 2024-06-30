

import java.util.*;

public class Main {

    public static int N;
    public static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new char[N][N];

        for(int i=0; i<N; i++){
            String input = sc.next();

            for(int j=0; j<N; j++){
                board[i][j] = input.charAt(j);
            }
        }

        int maxLength = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j+1<N){
                    swap(i,j,i,j+1);
                    maxLength = Math.max(maxLength, maxLength());
                    swap(i,j,i,j+1);
                }
                if(i+1<N){
                    swap(i,j,i+1,j);
                    maxLength = Math.max(maxLength, maxLength());
                    swap(i,j,i+1,j);
                }
            }
        }
        System.out.println(maxLength);
    }

    public static int maxLength(){
        int max = 0;

        for(int i=0; i<N; i++){
            int cnt = 1;
            for(int j=1; j<N; j++){
                if(board[i][j] == board[i][j-1]){
                    cnt++;
                } else{
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        for(int j=0; j<N; j++){
            int cnt = 1;
            for(int i=1; i<N; i++){
                if(board[i][j] == board[i-1][j]){
                    cnt++;
                } else{
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

}
