import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static boolean[][] board;
    public static int min = 64; // 최대로 바꿔야 할 칸의 수는 8x8 체스판에서 모든 칸을 바꾸는 경우이므로 64

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        board = new boolean[N][M];

        // 입력 받기, B는 true, W는 false로 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'B') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        // 모든 8x8 크기의 부분 보드를 검사
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        // 첫 번째 칸의 색
        boolean firstColor = board[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색이 아니라면 count를 증가
                if (board[i][j] != firstColor) {
                    count++;
                }
                // 다음 칸은 색이 바뀌어야 함
                firstColor = (!firstColor);
            }
            // 다음 줄로 넘어가면 색이 바뀌어야 함
            firstColor = !firstColor;
        }

        // 첫 번째 칸을 기준으로 할 때와 그 반대의 경우 중 최소값을 count에 저장
        count = Math.min(count, 64 - count);

        // 지금까지의 최소값과 비교
        min = Math.min(min, count);
    }
}