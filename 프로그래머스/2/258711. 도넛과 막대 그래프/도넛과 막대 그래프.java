import java.util.*;

class Solution {
    
    Map<Integer, Node> nodes = new HashMap<>();
    Set<Integer> arr = new HashSet<>();
    
    public int[] solution(int[][] edges) {
        init(edges);

        Node king = findKing();
        System.out.println(king.name);
    
        for (int key : nodes.keySet()) {
            Node node = nodes.get(key);
            node.removeKing(king.name);
        } 
        
        int stick = 0;
        int donut = 0;
        int eight = 0;
        
        for (int key : nodes.keySet()) {
            if (key == king.name) {
                continue;
            }
            Node node = nodes.get(key);
            if (node.in.isEmpty()) {
                stick++;
            } else if (node.in.size() >= 2 && node.out.size() >= 2) {
                eight++;
            }
        }
       
        donut = king.out.size() - stick - eight;
    
        return new int[]{king.name, donut, stick, eight};
    }
    
    public Node findKing() {
        for (int key : nodes.keySet()) {
            Node node = nodes.get(key);
            if (node.in.isEmpty() && node.out.size() >=2) {
                return node;
            }
        }
        return null;
    }
    
    public void init(int[][] edges) {
        for (int[] edge : edges) {
            arr.add(edge[0]);
            arr.add(edge[1]);
        }
        for (int a : arr) {
            nodes.put(a, new Node(a));
        }
        
        for (int[] edge : edges) {
            Node target = nodes.get(edge[0]);
            Node conn = nodes.get(edge[1]);
            
            target.out.add(conn.name);
            conn.in.add(target.name);
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
    
    public void removeKing(int king) {
        if (in.contains(king)) {
            in.remove(Integer.valueOf(king));
        }
    }
}