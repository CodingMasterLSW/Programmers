import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int minus;
    static int zero;
    static int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void recursion(int x, int y, int size) {

        if (size == 1) {
            if (graph[x][y] == 0) {
                zero +=1;
                return;
            }
            if (graph[x][y] == 1) {
                plus += 1;
                return;
            }
            if (graph[x][y] == -1) {
                minus +=1;
                return;
            }
        }

        if (validateSame(x, y, size)) {
            if (graph[x][y] == 0) {
                zero += 1;
                return;
            }

            if (graph[x][y] == 1) {
                plus += 1;
                return;
            }

            if (graph[x][y] == -1) {
                minus += 1;
                return;
            }
        }

        int newSize = size / 3;

        recursion(x, y, newSize);
        recursion(x+newSize, y, newSize);
        recursion(x+2*newSize, y, newSize);
        recursion(x, y+newSize, newSize);
        recursion(x+newSize, y+newSize, newSize);
        recursion(x+2*newSize, y+newSize, newSize);
        recursion(x, y+2*newSize, newSize);
        recursion(x+newSize, y+2*newSize, newSize);
        recursion(x+2*newSize, y+2*newSize, newSize);
    }

    public static boolean validateSame(int x, int y, int size) {
        int compareNum = graph[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (graph[i][j] != compareNum) {
                    return false;
                }
            }
        }
        return true;
    }

}
