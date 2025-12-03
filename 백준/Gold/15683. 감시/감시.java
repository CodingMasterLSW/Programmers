// 만들어야 할 함수
// 1) CCTV 위치 설정하기
// 결국 중요한건 [[left], [left, right], [left, right], [left, right, down], [left, right, down, up]]

// 1-1) 움직임 미리 정의하기
// 1번 = {{left}, {right}, {up}, {down}} 존재
// 2번 = {{left, right}, {up,down}} 존재
// 3번 = {{up, right}, {right, down}, {down, left}, {left, up}}
// 4번 = {{left, up, right}, {up, right, down}, {right, down, left}, {down, left, up}}
// 5번 = {{up, down, left, right}}
// 이런 움직임을 미리 만들어놓는다. 
// 여기까지 완료 
// Enum으로 정의를 해도 좋을 것 같음. ONE (movement), TWO(movement) 이런식으로

// 1-2) 각 움직임 별 함수를 만들어줘야 함. left, right, up, down 
// 1-3) backtracking으로 움직임 완전 탐색
// - {{left}, {left, right}, {up, right}, {left, up, right}, {up, down, left, right}}
// for (int i=1; i<5=; i++) {} 이런식으로 돌면서? 


// 2) CCTV 설정 후, 개수 사각지대 개수 구하기
// 3) 최소값 비교
// 다시 1)로

import java.util.*;
import java.io.*;
class Main {

    static int N;
    static int M;
    static int[][] graph;
    static int[][] copyGraph;
    static int minValue = Integer.MAX_VALUE;
    static List<Cctv> cctvs = new ArrayList<>();
    static Movement[][] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        copyGraph = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    cctvs.add(new Cctv(Type.ONE, new int[]{i,j}));
                }

                if (graph[i][j] == 2) {
                    cctvs.add(new Cctv(Type.TWO, new int[]{i,j}));
                }

                if (graph[i][j] == 3) {
                    cctvs.add(new Cctv(Type.THREE, new int[]{i,j}));
                }

                if (graph[i][j] == 4) {
                    cctvs.add(new Cctv(Type.FOUR, new int[]{i,j}));
                }

                if (graph[i][j] == 5) {
                    cctvs.add(new Cctv(Type.FIVE, new int[]{i,j}));
                }
            }
        }
        copyGraph();
        selected = new Movement[cctvs.size()][];
        backtracking(0);
        System.out.println(minValue);
    }

    public static void backtracking(int depth) {
        if (depth == cctvs.size()) {
            cal();
            return;
        }

        Cctv cctv = cctvs.get(depth);
        Movement[][] moveSet = cctv.type.movement;
        int x = cctv.location[0];
        int y = cctv.location[1];

        for (Movement[] moves : moveSet) {
            copyGraph();
            selected[depth] = moves;
            simulateFixedCctv(depth);

            for (Movement m : moves) {
                if (m == Movement.UP) up(x,y);
                if (m == Movement.DOWN) down (x,y);
                if (m == Movement.LEFT) left(x, y);
                if (m == Movement.RIGHT) right(x, y);
            }
            backtracking(depth + 1);
        }
    }

    public static void simulateFixedCctv(int depthLimit) {
        for (int d = 0; d < depthLimit; d++) {
            Cctv c = cctvs.get(d);
            int x = c.location[0];
            int y = c.location[1];

            for (Movement m : selected[d]) {
                if (m == Movement.UP) up(x,y);
                if (m == Movement.DOWN) down (x,y);
                if (m == Movement.LEFT) left(x, y);
                if (m == Movement.RIGHT) right(x, y);
            }
        }
    }

    public static void copyGraph() {
        for (int i=0; i<graph.length; i++) {
            copyGraph[i] = Arrays.copyOf(graph[i], graph[i].length); 
        }
    }

    public static void cal() {    
        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (copyGraph[i][j] == 0) {
                    count++;
                }
            }
        }
        minValue = Math.min(count, minValue);
    }

    public static void up(int col, int row) {
        // 행 --
        while (true) {
            if (col < 0 || copyGraph[col][row] == 6) {
                break;
            }
            copyGraph[col][row] = -1;
            col--;
        }
    }

    public static void down(int col, int row) {
        // 열 ++
        while (true) {
            if (col >= N || copyGraph[col][row] == 6) {
                break;
            }
            copyGraph[col][row] = -1;
            col++;
        }
    }

    public static void left(int col, int row) {
        while (true) {
            if (row < 0 || copyGraph[col][row] == 6) {
                break;
            }
            copyGraph[col][row] = -1;
            row--;
        }
    }

    public static void right(int col, int row) {
        while (true) {
            if (row >= M || copyGraph[col][row] == 6) {
                break;
            }
            copyGraph[col][row] = -1;
            row++;
        }
    }
}

class Cctv {
    Type type;
    int[] location;

    public Cctv(Type type, int[] location) {
        this.type = type;
        this.location = location;
    }
}

enum Movement {
    UP, DOWN, LEFT, RIGHT

}

enum Type {
    ONE(1, new Movement[][]{
        {Movement.UP},
        {Movement.DOWN},
        {Movement.RIGHT},
        {Movement.LEFT}
    }),
    TWO(2, new Movement[][] {
        {Movement.UP, Movement.DOWN},
        {Movement.LEFT, Movement.RIGHT}
    }),
    THREE(3, new Movement[][]{
        {Movement.UP, Movement.RIGHT},
        {Movement.RIGHT, Movement.DOWN},
        {Movement.DOWN, Movement.LEFT},
        {Movement.LEFT, Movement.UP}
    }),
    FOUR(4, new Movement[][] {
        {Movement.LEFT, Movement.UP, Movement.RIGHT},
        {Movement.UP, Movement.RIGHT, Movement.DOWN},
        {Movement.RIGHT, Movement.DOWN, Movement.LEFT},
        {Movement.DOWN, Movement.LEFT, Movement.UP}
    }),
    FIVE(5, new Movement[][] {
        {Movement.LEFT, Movement.RIGHT, Movement.UP, Movement.DOWN}
    });

    public int value;
    public Movement[][] movement;

    Type(int value, Movement[][] movement) {
        this.value = value;
        this.movement = movement;
    }
}
