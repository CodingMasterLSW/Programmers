import java.io.*;
import java.util.*;

class Main {

    static int[] result;
    static boolean[] visited;
    static Map<Integer, Node> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        visited = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            nodes.put(i, new Node(i));
        }
        
        // 노드들 초기화
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).connected.add(b);
            nodes.get(b).connected.add(a);
        }
        
        // 루트 노드 기준 dfs 시작
        dfs(r);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(result[query]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int dfs(int startNode) {
        Node node = nodes.get(startNode);
        visited[node.name] = true;
        int count = 1; // 자기 자신

        for (int c : node.connected) {
            if (visited[c]) {
                continue;
            }
            count += dfs(c);
        }
        visited[node.name] = false;
        result[startNode] = count;
        return count;
    }
}

class Node {

    int name;
    Set<Integer> connected = new HashSet<>();

    public Node(int name) {
        this.name = name;
    }
}