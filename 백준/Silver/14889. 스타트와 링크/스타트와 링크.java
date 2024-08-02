import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0);
        System.out.println(minDifference);
    }

    public static void backtracking(int start ,int count){
        if(count == N/2){
            calculate();
            return;
        }
        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                backtracking(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    public static void calculate(){
        int startTeam = 0;
        int linkTeam = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i] && visited[j]){
                    startTeam += graph[i][j] + graph[j][i];
                } else if (!visited[i] && !visited[j]){
                    linkTeam += graph[i][j] + graph[j][i];
                }
            }
        }
        int difference = Math.abs(startTeam-linkTeam);
        if(difference < minDifference){
            minDifference = difference;
        }
    }

}
