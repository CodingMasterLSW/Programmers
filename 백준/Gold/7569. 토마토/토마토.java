

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int m;
    static int n;
    static int h;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    static int[][][] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        sc.nextLine();

        box = new int[n][m][h];

        for (int b = 0; b < h; b++) {
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");

                for (int j = 0; j < m; j++) {
                    box[i][j][b] = Integer.parseInt(input[j]);
                    if (box[i][j][b] == 1) {
                        q.add(new int[]{i, j, b});
                    }
                }
            }

        }
        System.out.println(bfs());

    }

    public static int bfs() {
        int days = 0;


        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int cur[] = q.poll();

                for (int i = 0; i < 6; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    int nh = cur[2] + dh[i];

                    if (nx >= 0 && ny >= 0 && nh >= 0 && nx < n && ny < m && nh < h
                            && box[nx][ny][nh] == 0) {
                        box[nx][ny][nh] = 1;
                        q.add(new int[]{nx, ny, nh});
                    }
                }
            }
            days++;

        }
        for (int x = 0; x < h; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (box[i][j][x] == 0) {
                        return -1;
                    }
                }
            }
        }
        return days - 1;
    }
}


