import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static Map<Integer, Node> nodes = new HashMap<>();
    static boolean[] visited;

    static int hideNumber = Integer.MAX_VALUE;
    static int distance = 0;
    static int canHideCnt = 0;
    static List<Integer> results = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node nodeA = nodes.get(a);
            Node nodeB = nodes.get(b);

            nodeA.connected.add(nodeB);
            nodeB.connected.add(nodeA);
        }
        visited[1] = true;
        bfs(new int[]{1, 0});
        
        Collections.sort(results);
        StringBuilder sb = new StringBuilder();
        sb.append(results.get(0)).append(" ").append(distance).append(" ").append(results.size());
        System.out.println(sb.toString());
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentNode = current[0];
            int depth = current[1];

            if (depth >= distance) {
                if (depth > distance) {
                    results.clear();
                    results.add(currentNode);
                    distance = depth;
                } else if (depth == distance) {
                    results.add(currentNode);
                }
            }

            Node node = nodes.get(currentNode);
            List<Node> connectedNodes = node.connected;

            for (Node n : connectedNodes) {
                if (!visited[n.name]) {
                    visited[n.name] = true;
                    q.offer(new int[]{n.name, depth + 1});

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