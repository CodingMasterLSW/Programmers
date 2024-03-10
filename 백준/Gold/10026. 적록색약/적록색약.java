

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] area;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        area = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String k = br.readLine();
            for (int j = 0; j < n; j++) {
                area[i][j] = k.charAt(j);
            }
        }
        int normalPerson = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {
                    char currentColor = area[i][j];
                    dfs(i, j, currentColor);
                    normalPerson++;
                }
            }
        }
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 'G') {
                    area[i][j] = 'R';
                }
            }
        }

        int colorBlindPerson = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    char currentColor = area[i][j];
                    dfs(i, j, currentColor);
                    colorBlindPerson++;
                }
            }

        }
        bw.write(String.valueOf(normalPerson) + " ");
        bw.write(String.valueOf(colorBlindPerson));

        bw.flush();
        bw.close();
    }


    public static void dfs(int x, int y, char currentColor) {

        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (area[x][y] != currentColor){
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], currentColor);
        }

    }


}
