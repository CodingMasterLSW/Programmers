import java.io.*;
import java.util.*;

class Main {

    static int N;
    static boolean[] visited;
    static Map<Integer, Node> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i=1; i<=N; i++) {
            Node node = nodes.get(i);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int currentValue = Integer.parseInt(st.nextToken());
                if (currentValue == 1) {
                    node.connected.add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            bfs(nodes.get(i));
            
            for (int j=1; j<=N; j++) {
                if (visited[j]) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }

    public static void bfs(Node startNode) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(startNode);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            List<Integer> connected = currentNode.connected;
            for (int conn : connected) {
                if (!visited[conn]) {
                    visited[conn] = true;
                    q.offer(nodes.get(conn));
                }
            }
        }
    }
}

class Node {
    int name;
    List<Integer> connected = new ArrayList<>();

    public Node(int name) {
        this.name = name;
    }

}