import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            maps.put(key, value);
        }
        int bfs = bfs(maps);
        System.out.println(bfs);

    }

    public static int bfs(Map<Integer,Integer> maps){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.offer(new int[]{1,0});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int idx = current[0];
            int count = current[1];
            if(idx == 100){
                return count;
            }

            for(int i=1; i<=6; i++){
                int nextIdx = idx+i;

                if(nextIdx>100){
                    continue;
                }

                if(visited[nextIdx]){
                    continue;
                }

                if(maps.containsKey(nextIdx)){
                    nextIdx = maps.get(nextIdx);
                }

                visited[nextIdx] = true;
                q.offer(new int[]{nextIdx, count+1});
            }
        }
        return -1;
    }


}
