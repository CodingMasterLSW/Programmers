import java.util.*;

class Solution {
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    
    
    public int solution(int[][] maps) {

        q.offer(new int[]{0,0,1});
        visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();

            int x = current[0];
            int y = current[1];
            int sum = current[2];

            if(x==maps.length-1 && y == maps[0].length-1){
                return sum;
            }


            for(int i=0; i<4; i++){
                int ndx = x + dx[i];
                int ndy = y + dy[i];

                if(ndx<0|| ndx>=maps.length || ndy<0 || ndy>=maps[0].length){
                    continue;
                }
                if(visited[ndx][ndy] || maps[ndx][ndy] == 0){
                    continue;
                }
                visited[ndx][ndy] = true;
                q.offer(new int[]{ndx, ndy, sum + 1});
            }


        }
        return -1;
    }
}