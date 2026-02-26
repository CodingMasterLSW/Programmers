// bfs
// 1 이상이면 친구 x

import java.io.*;
import java.util.*;

class Main {

    static Map<Integer, Node> nodes = new HashMap<>();
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            nodes.put(i, new Node(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node a = nodes.get(Integer.parseInt(st.nextToken()));
            Node b = nodes.get(Integer.parseInt(st.nextToken()));

            a.connected.add(b.name);
            b.connected.add(a.name);
        }

        visited[1] = true;
        bfs(new int[]{1, 0});
        System.out.println(cnt);
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int[] current = q.poll();
            Node node = nodes.get(current[0]);

            if (current[1] > 1) {
                break;
            }

            List<Integer> conn = node.connected;

            for (int c : conn) {
                if (visited[c]) {
                    continue;
                }
                //System.out.println("c = " + c); 
                visited[c] = true;
                cnt++;
                q.offer(new int[]{c, current[1] + 1});
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