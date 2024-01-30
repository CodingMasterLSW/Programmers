

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];

        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int componentCount = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                componentCount++;
            }
        }
        System.out.println(componentCount);

    }

    static void dfs(int node){
        visited[node] = true;

        for(int i: graph.get(node)){
            if(!visited[i]){
                dfs(i);
            }
        }

    }

}
