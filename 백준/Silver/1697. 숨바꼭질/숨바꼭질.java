
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;

    static int[] count;
    static int[] dir = {1,-1,2};

    static int max = 100000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());

        count = new int[max+1];

        bfs(N);
    }


    static void bfs(int n){
        boolean[] visited = new boolean[max+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        count[n] = 0;
        visited[n] = true;

        while(!q.isEmpty()){

            int currentLocation = q.poll();
            if(currentLocation==K){
                System.out.println(count[currentLocation]);
                return;
            }

            for(int i=0; i<3; i++){
                int nextLocation;

                if(i==2){
                    nextLocation = currentLocation * dir[i];
                } else{
                    nextLocation = currentLocation + dir[i];
                }

                if(nextLocation<0 || nextLocation>max){
                    continue;
                }

                if(!visited[nextLocation]){
                    visited[nextLocation] = true;
                    q.add(nextLocation);

                    count[nextLocation] = count[currentLocation]+1;
                }
            }
        }

    }

}
