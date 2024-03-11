

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Main {

    static int cnt = -1;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        int m = Integer.parseInt(br.readLine());


        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            lists.get(a).add(b);
            lists.get(b).add(a);
        }
        dfs(x,y,0);
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int end, int depth){
        visited[start] = true;

        if(start==end){
            cnt = depth;
            return;
        }

        for(int next : lists.get(start)){
            if(!visited[next]){
                dfs(next, end, depth + 1);
            }
        }
    }
}
