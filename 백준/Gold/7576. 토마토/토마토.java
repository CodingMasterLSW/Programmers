import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static int currentMax = 1;
    static boolean[][] visited;
    static List<int[]> starts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                   starts.add(new int[]{i,j});
                   visited[i][j] = true;
                }
            }
        }
        bfs(starts);

        int res = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j] == 0){
                    res++;
                }
            }
        }
        if(res == 0){
            System.out.println(currentMax-1);
        } else{
            System.out.println("-1");
        }
    }
    public static void bfs(List<int[]> starts){
        Queue<int[]> q = new LinkedList<>(starts);

        while(!q.isEmpty()){
            int current[] = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i=0; i<4; i++){
                int ndx = currentX + dx[i];
                int ndy = currentY + dy[i];

                if(ndx<0 || ndx>=N || ndy<0 || ndy>=M){
                    continue;
                }
                if(visited[ndx][ndy] || graph[ndx][ndy]!= 0){
                    continue;
                }

                visited[ndx][ndy] = true;

                q.offer(new int[]{ndx,ndy});

                graph[ndx][ndy] = graph[currentX][currentY]+1;
                if(currentMax<graph[ndx][ndy]){
                    currentMax = graph[ndx][ndy];
                }
            }
        }

    }
}
