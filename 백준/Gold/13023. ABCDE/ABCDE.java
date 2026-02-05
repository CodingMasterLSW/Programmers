import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static Node[] nodes;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new Node[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            nodes[i] = new Node(i);
        }


        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int connect = Integer.parseInt(st.nextToken());
            nodes[x].add(connect);
            nodes[connect].add(x);
        }
        //System.out.println(Arrays.toString(nodes));
        for (int i=0; i<N; i++) {
            dfs(nodes[i].getX(), 0);
            if (found) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static void dfs(int current, int depth) {
        // 종료 조건
        if (depth == 4) {
            found = true;
            return;
        }
        
        visited[current] = true;

        Node currentNode = nodes[current];

        for (int friend : currentNode.getFreinds()) {
            if (!visited[friend]) {
                visited[friend] = true;
                dfs(friend, depth +1);
                if (found) {
                    return;
                }
            }
        }
        visited[current] = false;
    }
}

class Node {
    private int x;
    private List<Integer> freinds = new ArrayList<>();

    public Node(int x) {
        this.x = x;
    }

    public void add(int value) {
        this.freinds.add(value);
    }

    public int getX() {
        return x;
    }

    public List<Integer> getFreinds() {
        return freinds;
    }
    
    @Override
    public String toString() {
        return "[x: " + x + ", nodes: " + freinds.toString() + "]";
    }
}