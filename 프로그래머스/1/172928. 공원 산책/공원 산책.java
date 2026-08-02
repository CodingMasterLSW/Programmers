import java.util.*;

class Solution {
    
    static char[][] graph;
    static int maxX;
    static int maxY;
    static int currentX;
    static int currentY;
    
    public int[] solution(String[] park, String[] routes) {
        
        graph = new char[park.length][park[0].length()];
        maxY = park[0].length()-1;
        maxX = park.length-1;
        
        for (int i=0; i<park.length; i++) {
            String current = park[i];
            
            for (int j=0; j<current.length(); j++) {
                graph[i][j] = current.charAt(j);
                if (graph[i][j] == 'S') {
                    currentX = i;
                    currentY = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] s = route.split(" ");
            String direction = s[0];
            String distance = s[1];
            
            move(direction, Integer.parseInt(distance));
        }
        
        return new int[]{currentX, currentY};
    }
    
    public static void move(String direction, int distance) {
        if (direction.equals("E")) {
            if (currentY + distance > maxY) {
                return;
            }
            for (int i = currentY; i <= currentY + distance; i++) {
                if (graph[currentX][i] == 'X') {
                    return;
                }
            }
            currentY += distance;
        }
        
        if (direction.equals("W")) {
            if (currentY - distance < 0) {
                return;
            }
            for (int i= currentY; i >= currentY - distance; i--) {
                if (graph[currentX][i] == 'X') {
                    return;
                }
            }
            currentY -= distance;
        }
        
        if (direction.equals("S")) {
            if (currentX + distance > maxX) {
                return;
            }
            for (int i = currentX; i <= currentX + distance; i++) {
                if (graph[i][currentY] == 'X') {
                    return;
                }
            }
            currentX += distance;
        }
        
        if (direction.equals("N")) {
            if (currentX - distance < 0) {
                return;
            }
            for (int i= currentX; i >= currentX - distance; i--) {
                if (graph[i][currentY] == 'X') {
                    return;
                }
            }
            currentX -= distance;
            
        }
    }
}