// 1) 각 그래프 노드 양방향 연결
// 2) bfs
// 3) 방문 안 한 곳 있으면 pass, 전부 다 방문했으면 +1

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int T;
    static Map<Integer, Node> nodes = new HashMap<>();
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            Node lowNode = nodes.get(Integer.parseInt(st.nextToken())); 
            Node upperNode = nodes.get(Integer.parseInt(st.nextToken())); 
            lowNode.upper.add(upperNode);
            upperNode.lower.add(lowNode);
        }

        int cnt = 0;

        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            upperBfs(nodes.get(i));
            lowerBfs(nodes.get(i));

            if (canCalculate()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean canCalculate() {
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void lowerBfs(Node startNode) {
        Queue<Node> q = new ArrayDeque<>();

        q.offer(startNode);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            List<Node> lower = currentNode.lower;

            for (Node l : lower) {
                if (!visited[l.name]) {
                    q.offer(l);
                    visited[l.name] = true;
                }
            }
        }
    }

    public static void upperBfs(Node startNode) {
        Queue<Node> q = new ArrayDeque<>();

        q.offer(startNode);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            List<Node> upper = currentNode.upper;

            for (Node u : upper) {
                if (!visited[u.name]) {
                    q.offer(u);
                    visited[u.name] = true;
                }
            }
        }
    }
}

class Node {
    int name;
    List<Node> upper = new ArrayList<>();
    List<Node> lower = new ArrayList<>();

    public Node(int name) {
        this.name = name;
    }
}