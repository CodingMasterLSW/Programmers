
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        
        // 그래프 초기화
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                graph[i][j] = str.charAt(j)-'0';
            }
        }
        recursion(0, 0, N);
        System.out.println(sb.toString());
    }
    
    public static void recursion(int x, int y, int length) {
        if (length == 1) {
            // 종료 조건
            if (graph[x][y] == 1) {
                sb.append("1");
                return;
            } else {
                sb.append("0");
                return;
            }
        }
        
        if (validateNumber(x, y, length)) {
            if (graph[x][y] == 1) {
                sb.append("1");
                return;
            } else {
                sb.append("0");
                return;
            }
        }
        
        // 종료 조건이 아니라면
        int newLength = length / 2;

        sb.append("(");

        recursion (x, y, newLength);
        recursion (x, y+newLength, newLength);
        recursion (x+newLength, y, newLength);
        recursion (x+newLength, y+newLength, newLength);

        sb.append(")");
    }
    
    public static boolean validateNumber(int x, int y, int length) {
        int compareNum = graph[x][y];
        
        for (int i=x; i<x+length; i++) {
            for (int j=y; j<y+length; j++) {
                if (compareNum != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
