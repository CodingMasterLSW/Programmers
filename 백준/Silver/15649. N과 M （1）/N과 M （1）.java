import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        int[] sequence = new int[M];
        cal(N,M, visited, sequence, 0);
    }
    public static void cal(int n, int m, boolean[] visited, int[] sequence, int depth){

        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(sequence[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence[depth] = i;
                cal(n, m, visited, sequence, depth+1);
                visited[i] = false;
            }
        }
    }
}
