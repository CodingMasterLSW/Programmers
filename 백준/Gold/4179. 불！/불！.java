import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static char[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = s.charAt(j);
            }
        }

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> escapeQ = new LinkedList<>();

        findFire(fireQ);
        findStart(escapeQ);

        int bfs = bfs(fireQ, escapeQ);
        if(bfs == -1){
            System.out.println("IMPOSSIBLE");
        } else{
            System.out.println(bfs);
        }
    }

    public static int bfs(Queue<int[]> fireQ, Queue<int[]> escapeQ){
        while(!escapeQ.isEmpty()){
            int size = fireQ.size();

            for(int i=0; i<size; i++){
                int[] fire = fireQ.poll();
                int fireX = fire[0];
                int fireY = fire[1];

                for(int d=0; d<4; d++){
                    int fireNX = fireX + dx[d];
                    int fireNY = fireY + dy[d];

                    if(fireNX<0 || fireNX>=N || fireNY<0 || fireNY>=M){
                        continue;
                    }
                    if(visited[fireNX][fireNY] || graph[fireNX][fireNY] != '.'){
                        continue;
                    }
                    visited[fireNX][fireNY] = true;
                    graph[fireNX][fireNY] = 'F';
                    fireQ.offer(new int[]{fireNX, fireNY});

                }
            }

            int escapeSize = escapeQ.size();
            for(int i=0; i< escapeSize; i++){
                int[] current = escapeQ.poll();
                int x = current[0];
                int y = current[1];
                int t = current[2];

                if(x==0 || x==N-1 || y==0 || y==M-1){
                    return t+1;
                }

                for(int d=0; d<4; d++){
                    int ndx = x + dx[d];
                    int ndy = y + dy[d];

                    if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                        continue;
                    }
                    if (visited[ndx][ndy] || graph[ndx][ndy] != '.') {
                        continue;
                    }

                    visited[ndx][ndy] = true;
                    escapeQ.offer(new int[]{ndx, ndy, t+1});
                }
            }
        }
        return -1;
    }


    public static void findFire(Queue<int[]> fireQ){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j] == 'F'){
                    fireQ.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
    }
    public static void findStart(Queue<int[]> escapeQ){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]=='J'){
                    escapeQ.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                    return;
                }
            }
        }
    }

}
