import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph;
    static int white;
    static int blue;
    static boolean[][] visited;
    static int current;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        current = N;
        bfs(0,0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void bfs(int x, int y, int n){
        boolean flag = true;
        int start = graph[x][y];
        for(int i=0; i<n; i++){
            if(!flag){
                break;
            }
            for(int j=0; j<n; j++){
                if(start != graph[x+i][y+j]){
                    flag = false;
                    break;
                }

            }
        }
        if(flag){
            if(graph[x][y] == 0){
                white++;
            } else{
                blue ++;
            }
        } else{
            int newSize = n/2;
            // 1
            bfs(x, y, newSize);
            //2
            bfs(x, y + newSize, newSize);
            // 3
            bfs(x + newSize, y, newSize);
            // 4
            bfs(x + newSize, y + newSize, newSize);
        }
    }


}
