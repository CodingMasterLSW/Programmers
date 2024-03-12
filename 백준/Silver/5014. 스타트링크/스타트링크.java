

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F,S,G;
    static int[] dir = new int[2];
    static int[] count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st1.nextToken()); // 전체 층
        S = Integer.parseInt(st1.nextToken()); // 현재 위치
        G = Integer.parseInt(st1.nextToken()); // 목표 이동 층
        dir[0] = Integer.parseInt(st1.nextToken()); // 위로 이동
        dir[1] = -Integer.parseInt(st1.nextToken()); // 아래로 이동

        count = new int[F+1];

        bfs(S);

    }

    static void bfs(int s){
        boolean[] visited = new boolean[F+1]; // 건물은 1층부터 시작
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        count[s] = 0;

        while(!q.isEmpty()){
            int currentFloor = q.poll();

            if(currentFloor == G){
                System.out.println(count[currentFloor]);
                return;
            }

            for(int i=0; i<2; i++){
                int next = currentFloor + dir[i];

                if(next > F || next<1){
                    continue;
                }
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    count[next] = count[currentFloor] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }

}

