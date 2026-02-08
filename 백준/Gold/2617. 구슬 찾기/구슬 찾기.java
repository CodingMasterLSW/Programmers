import java.io.*;
import java.util.*;

class Main {

    static Map<Integer, Ball> balls = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i=1; i<=n; i++) {
            Ball ball = new Ball(i);
            balls.put(i, ball);
        }
        
        for (int i=0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            Ball ball1 = balls.get(a);
            Ball ball2 = balls.get(b);

            ball1.down.add(ball2.name);
            ball2.up.add(ball1.name);
        }

        int result = 0;
        for (int i=1; i<=n; i++) {
            int count1 = upBfs(i);
            int count2 = downBfs(i);

            if ((n / 2) + 1 <= count1 || (n / 2) + 1 <= count2) {
                result++;
            }
        }
        System.out.println(result);

    }

    public static int upBfs(int startBall) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        q.offer(startBall);
        visited.add(startBall);

        while (!q.isEmpty()) {
            int current = q.poll();

            Ball ball = balls.get(current);
            Set<Integer> ups = ball.up;
            for (int up : ups) {
                if (!visited.contains(up)) {
                    visited.add(up);
                    q.offer(up);
                    count++;
                }
            }
        }
        return count;
    }

    public static int downBfs(int startBall) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        q.offer(startBall);
        visited.add(startBall);

        while (!q.isEmpty()) {
            int current = q.poll();
            Ball ball = balls.get(current);
            Set<Integer> downs = ball.down;
            for (int down : downs) {
                if (!visited.contains(down)) {
                    visited.add(down);
                    q.offer(down);
                    count++;
                }
            }
        }
        return count;
    }
}

class Ball {
    int name;
    Set<Integer> up = new HashSet<>();
    Set<Integer> down = new HashSet<>();

    public Ball(int name) {
        this.name = name;
    }
}