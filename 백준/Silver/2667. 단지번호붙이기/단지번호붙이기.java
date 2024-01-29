import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


//dfs로 재귀적으로 보기.
public class Main {

    public static int k;
    public static List<Integer> lists = new ArrayList<>();
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int[][] graph;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sc.nextLine();

        graph = new int[k][k];
        visited = new boolean[k][k];

        for(int i=0; i<k; i++){
            String input = sc.nextLine();

            for(int j=0; j<k; j++){
                graph[i][j] = input.charAt(j) - '0';
            }
        }
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    lists.add(dfs(i,j));
                }
            }

        }
        Collections.sort(lists);
        System.out.println(lists.size());
        for (int size : lists){
            System.out.println(size);
        }

    }

    public static int dfs(int x, int y) {
        if (x < 0 || x >= k || y < 0 || y >= k) {
            return 0;
        }
        if (graph[x][y] == 0 || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            size += dfs(x + dx[i], y + dy[i]);
        }
        return size;
    }

}
