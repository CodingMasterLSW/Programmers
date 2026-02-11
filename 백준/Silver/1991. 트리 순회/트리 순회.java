import java.io.*;
import java.util.*;

class Main {

    static int N;
    static Map<Character, Node> nodes = new HashMap<>();   
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        // 노드 초기화
        for (int i=0; i<N; i++) {
            char name = (char) ('A' + i);
            nodes.put(name ,new Node(name));
        }

        // 그래프 초기화
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node node = nodes.get(target);
            if (left != '.') {
                node.left = nodes.get(left);
            }
            if (right != '.') {
                node.right = nodes.get(right);
            }
        }
        preOrder(nodes.get('A'));
        System.out.println(sb.toString());
        
        sb = new StringBuilder();
        inOrder(nodes.get('A'));
        System.out.println(sb.toString());

        sb = new StringBuilder();
        postOrder(nodes.get('A'));
        System.out.println(sb.toString());
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.name);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        sb.append(node.name);
        inOrder(node.right);

    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.name);
    }
}

class Node {
    char name;
    Node left;
    Node right;

    public Node(char name) {
        this.name = name;
    }
}