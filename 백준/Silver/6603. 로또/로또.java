import java.util.*;

public class Main {

    public static final int MAX_NUM = 6;
    static int N;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            N = sc.nextInt();
            if(N==0){
                break;
            }
            arr = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            int[] resources = new int[N];
            backtracking(resources, 0, 0);
            System.out.println();
        }
    }

    public static void backtracking(int[] resources, int depth, int start){
        if(depth == MAX_NUM){
            for(int i=0; i<MAX_NUM; i++){
                System.out.print(resources[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                resources[depth] = arr[i];
                backtracking(resources, depth+1, i);
                visited[i] = false;
            }
        }
    }
}
