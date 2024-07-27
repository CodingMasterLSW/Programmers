import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0,0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void bfs(int x, int y, int n){
        if(isTrue(x,y,n)){
            if(graph[x][y] == 0){
                white++;
            } else{
                blue++;
            }
        }
        else{
            int calN = n/2;
            //1
            bfs(x, y, calN);
            //2
            bfs(x, y+ calN, calN);
            //3
            bfs(x+calN, y, calN);
            //4
            bfs(x+calN, y+calN, calN);
        }

    }

    public static boolean isTrue(int x, int y, int n){
        int start = graph[x][y];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(start != graph[x+i][y+j]){
                    return false;
                }
            }
        }
        return true;
    }

}
