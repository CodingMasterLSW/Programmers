import java.util.*;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();


        int[] resources = new int[M];
        backtracking(N, M, resources, 0, 1);

        System.out.println(sb.toString());
    }

    public static void backtracking(int n, int m, int[] resources, int depth, int start){
        if(M==depth){
            for(int i=0; i<M; i++){
                sb.append(resources[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            resources[depth] = i;
            backtracking(n, m, resources, depth+1, i);
        }
    }
}