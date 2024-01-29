

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토는 bfs를 사용해보자
public class Main {

    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {

            String[] numbers = sc.nextLine().split(" ");

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(numbers[j]);
                if (graph[i][j] == 1) {
                    q.add(new int[]{i, j});
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
                int[] cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length
                            && graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }

                }


            }
            days++;
        }
        for (int i =0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if(graph[i][j]==0){
                    return -1;
                }
            }
        }
        return days-1;
    }

}
