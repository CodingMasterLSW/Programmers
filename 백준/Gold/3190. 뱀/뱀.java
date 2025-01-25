
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int currentDirection = 0;
    static int time;
    static int currentX = 1;
    static int currentY = 1;
    static int N;

    static Deque<int[]> snake = new ArrayDeque<>();
    static Queue<String[]> q = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1; // 사과 설정
        }

        int K = Integer.parseInt(br.readLine());

        // 위치 변경 q에 삽입
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String distance = st.nextToken();
            String direction = st.nextToken();
            q.offer(new String[]{distance, direction});
        }

        snake.offer(new int[]{1,1});

        while (true) {
            if (!q.isEmpty()) {
                String[] peek = q.peek();
                int distance = Integer.parseInt(peek[0]);
                String direction = peek[1];

                if (distance == time) {
                    changeDirection(direction);
                    q.poll();
                }
            }

            boolean canMove = move();
            if (!canMove) {
                System.out.println(time+1);
                break;
            }

        }
    }

    public static void changeDirection(String direction) {
        if (direction.equals("D")) {
            currentDirection = (currentDirection + 1) % 4;
        }
        if (direction.equals("L")) {
            currentDirection = (currentDirection+ 3)% 4;
        }
    }

    public static boolean move() {
        int nextX = currentX;
        int nextY = currentY;

        if (currentDirection == 0) nextY++; // 오
        if (currentDirection == 1) nextX++; // 하단
        if (currentDirection == 2) nextY--; // 왼
        if (currentDirection == 3) nextX--; // 상단


        if (!checkRange(nextX, nextY) || checkCollision(nextX, nextY)) {
            return false;
        }

        snake.addFirst(new int[]{nextX, nextY});
        currentX = nextX;
        currentY = nextY;

        if (graph[nextX][nextY] == 1) {
            graph[nextX][nextY] = 0; // 사과 먹기
        } else {
            snake.pollLast(); // 꼬리 제거
        }
        time++;
        return true;
    }

    public static boolean checkRange(int x, int y) {
        if (x >= 1 && x <= N && y >= 1 && y <= N) {
            return true;
        }
        return false;
    }

    public static boolean checkCollision(int x, int y) {

        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) {
                return true;
            }
        }
        return false;
    }
}
