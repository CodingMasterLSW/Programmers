import java.io.*;
import java.util.*;

class Main {

    static int T;
    static Map<Integer, Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int z=0; z<T; z++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            nodes = new HashMap<>();

            for (int i=1; i<=N; i++) {
                nodes.put(i, new Node(i));
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());

                Node node1 = nodes.get(Integer.parseInt(st.nextToken()));
                Node node2 = nodes.get(Integer.parseInt(st.nextToken()));
                node1.connected.add(node2.name);
                node2.connected.add(node1.name);
            }

            boolean flag = true;

            for (int i=1; i<=N; i++) {
                Node node = nodes.get(i);
                if (node.color == 0) {
                    node.color = 1;
                    boolean result = bfs(node.name);
                    if (!result) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean bfs(int startName) {
        Node node = nodes.get(startName);
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()) {
            Node current = q.poll();
            int currentColor = current.color;
            
            List<Integer> connected = current.connected;

            for (int conn : connected) {
                Node target = nodes.get(conn);

                if (target.color == currentColor) {
                    return false;
                }

                if (target.color == 0) {
                    if (currentColor == 1) {
                        target.color = 2;
                    } else if (currentColor == 2) {
                        target.color = 1;
                    }
                    q.offer(target);
                } else {
                    continue;
                }
                
            }
        }
        return true;
    }
}

class Node {
    int name;
    List<Integer> connected = new ArrayList<>();
    int color = 0;

    public Node(int name) {
        this.name = name;
    }
}