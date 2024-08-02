import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int depth =0;
        int[] resources = new int[M];
        boolean[] visited = new boolean[N+1];

        backtracking(depth, resources, visited);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth, int[] resources, boolean[] visited){
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(resources[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                resources[depth] = i;
                backtracking(depth+1, resources, visited);
                visited[i] = false;
            }
        }
    }

}
