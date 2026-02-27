import java.io.*;
import java.util.*;

class Main {

    static int[][] graph = new int[101][101];
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int z=0; z<N; z++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            for (int i = row1; i<=row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    graph[i][j] +=1;
                }
            }
        }

        int cnt = 0;
        for (int i=1; i<=100; i++) {
            for (int j=1; j<=100; j++) {
                if (graph[i][j] > M) {
                    cnt++;
                }
            }   
        }
        System.out.println(cnt);
    }
}