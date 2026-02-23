import java.util.*;

class Solution {
    
    static Map<Integer, Node> nodes = new HashMap<>();
    static boolean[] visited;
    
    public int[] solution(int[][] edges) {
        init(edges);
        
        Node connectNode = findConnectNode();
        removeConnectNodeIn(connectNode);
        
        int donut = 0;
        int eight = 0;
        int stick = 0;
        
       
        for (int i : connectNode.out) {
            if (i == connectNode.name) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int value = dfs(nodes.get(i));
            
            if (value == 1) {
                eight++;
            } else if (value == 2) {
                donut++;
            } else if (value == 3) {
                stick++;
            }
        }

        return new int[]{connectNode.name, donut, stick, eight};
    }
    
    private int dfs(Node startNode) {
        boolean hasDoubleOut = false;
        Node current = startNode;
        
        while (true) {
            if (current.out.isEmpty()) {
                return 3;
            }
            
            if (current.out.size() == 2) {
                hasDoubleOut = true;
            }
            
            int nextNode = current.out.get(0);
            if (visited[nextNode]) {
                break;
            }
            visited[nextNode] = true;
            current = nodes.get(nextNode);
        }
        if (hasDoubleOut) {
            return 1;
        }
        return 2;
        
    }
    
    private void removeConnectNodeIn(Node connectNode) {
        for (int key : nodes.keySet()) {
            if (key == connectNode.name) {
                continue;
            }
            Node node = nodes.get(key);
            node.removeConnect(connectNode.name);
        }
    }
    
    private Node findConnectNode() {
        for (int key : nodes.keySet()) {
            Node node = nodes.get(key);
            if (node.out.size() >= 2 && node.in.isEmpty()) {
                return node;
            }
        }
        return null;
    }
    
    private void init(int[][] edges) {
        Set<Integer> values = new HashSet<>();
        
        for (int[] edge : edges) {
            values.add(edge[0]);
            values.add(edge[1]);
        }
        
        int maxNode = Collections.max(values);
        visited = new boolean[maxNode + 1];
        
        for (int v :values) {
            nodes.put(v, new Node(v));
        }      
        
        for (int[] edge : edges) {
            Node target = nodes.get(edge[0]);
            Node connect = nodes.get(edge[1]);
            
            target.out.add(connect.name);
            connect.in.add(target.name);
        }
    }
}

class Node {
    int name;
    List<Integer> in = new ArrayList<>();
    List<Integer> out = new ArrayList<>();
    
    public Node(int name) {
        this.name = name;
    }
    
    public void removeConnect(int target) {
        if (in.contains(target)) {
            in.remove(new Integer(target));
        }
    }
}