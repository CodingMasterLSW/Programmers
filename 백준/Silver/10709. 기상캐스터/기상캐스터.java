
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[][] graph;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N][M];

        Deque<int[]> arr = new ArrayDeque<>();

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = String.valueOf(s.charAt(j));
                if (graph[i][j].equals("c")) {
                    graph[i][j] = "0";
                    arr.offer(new int[]{i,j});
                }
                if (graph[i][j].equals(".")) {
                    graph[i][j] = "-1";
                }
            }
        }

        while (!arr.isEmpty()) {
            int currentTime = 1;
            int[] poll = arr.pollLast();
            int x = poll[0];
            int y = poll[1];

            for (int i=y; i<M; i++) {
                if (graph[x][i].equals("-1")) {
                    graph[x][i] = String.valueOf(currentTime);
                    currentTime++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }
}
