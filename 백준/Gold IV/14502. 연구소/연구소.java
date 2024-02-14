

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static List<int[]> startPlot = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSize;
    static int[][] graph;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
                if (graph[i][j] == 2) {
                    int x = i;
                    int y = j;
                    startPlot.add(new int[]{x, y});
                }

            }
        }
        dfs(0, graph);
        bw.write(String.valueOf(maxSize));
        bw.flush();
        bw.close();
    }

    static void bfs(int[][] tempGraph){

        Queue<int[]> q = new LinkedList<>();
        for(int[] virus : startPlot){
            q.add(new int[]{virus[0], virus[1]});
        }

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {
                int cur[] = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && tempGraph[nx][ny] == 0) {
                        tempGraph[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

        }

    }

    static void dfs(int cnt, int[][] graph) {
        if (cnt == 3) {
            int[][] tempGraph = new int[n][m];
            for(int i=0; i<n; i++){
                System.arraycopy(graph[i],0,tempGraph[i],0,m);
            }
            bfs(tempGraph);

            int safeAreas = calculateSafeArea(tempGraph);
            maxSize = Math.max(maxSize, safeAreas);
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]== 0){
                    graph[i][j]=1;
                    dfs(cnt+1, graph);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static int calculateSafeArea(int[][] tempGraph){
        int safe = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (tempGraph[i][j] == 0){
                    safe++;
                }
            }
        }
        return safe;
    }

}
