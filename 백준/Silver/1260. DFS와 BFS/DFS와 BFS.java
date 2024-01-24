

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int v = Integer.parseInt(st1.nextToken());

        // 방문 배열 초기화
        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 간선 정보를 입력받아 그래프 구성
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            // 무방향 그래프이므로 양방향으로 간선 추가
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 그래프의 각 정점에 대해 인접 리스트 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);

        bfs(v);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int i : graph.get(node)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

}
