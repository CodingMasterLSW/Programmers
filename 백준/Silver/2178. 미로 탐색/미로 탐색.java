import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i=0; i<4; i++){
                int ndx = currentX + dx[i];
                int ndy = currentY + dy[i];

                if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                    continue;
                }
                if (visited[ndx][ndy] || graph[ndx][ndy] != 1){
                    continue;
                }

                visited[ndx][ndy] = true;
                q.offer(new int[]{ndx,ndy});

                graph[ndx][ndy] = graph[currentX][currentY]+1;

                if(ndx == N-1 && ndy == M-1){
                    return graph[ndx][ndy];
                }

            }
        }
        return -1;
    }
}
