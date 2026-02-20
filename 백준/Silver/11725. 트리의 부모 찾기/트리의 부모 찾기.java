import java.io.*;
import java.util.*;

class Main {

    static Map<Integer, Node> nodes = new HashMap<>();
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parents = new int[N+1];

        for (int i=1; i<=N; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node1 = nodes.get(Integer.parseInt(st.nextToken()));
            Node node2 = nodes.get(Integer.parseInt(st.nextToken()));

            node1.connected.add(node2);
            node2.connected.add(node1);
        }

        bfs(nodes.get(1));

        StringBuilder sb = new StringBuilder();

        for (int i=2; i<=N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(Node startNode) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(startNode);

        while(!q.isEmpty()) {
            Node currentNode = q.poll();

            List<Node> nodes = currentNode.connected;

            for (Node node : nodes) {
                if (!visited[node.name]) {
                    visited[node.name] = true;
                    parents[node.name] = currentNode.name;
                    q.offer(node);
                }
            }
        }
    }
}

class Node {
    int name;
    List<Node> connected = new ArrayList<>();

    public Node(int name) {
        this.name = name;
    }
}