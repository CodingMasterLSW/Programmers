import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);

        }
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();

        for(int i=1; i<=N; i++){
            if(min>bfs(i)){
                min = bfs(i);
                if(!res.isEmpty()){
                    res.clear();
                }
                res.add(i);
            }
        }

        Collections.sort(res);
        System.out.println(res.get(0));

    }

    public static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        int sum = 0;
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int curNode = poll[0];
            int curDistance = poll[1];
            sum += curDistance;

            ArrayList<Integer> integers = graph.get(curNode);
            for (Integer integer : integers) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    q.offer(new int[]{integer, curDistance + 1});
                }
            }
        }
        return sum;
    }

}
