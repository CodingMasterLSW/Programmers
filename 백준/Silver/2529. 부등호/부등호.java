import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static char[] arr;
    static boolean[] visited;
    static int[] maxResult;
    static int[] minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        visited = new boolean[11];
        maxResult = new int[N+1];
        minResult = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        maxBacktracking(0);
        StringBuilder sb = new StringBuilder();

        for (int r : maxResult) {
            sb.append(r);
        }
        System.out.println(sb.toString());

        visited = new boolean[11];
        sb = new StringBuilder();
        minBacktracking(0);


        for (int r : minResult) {
            sb.append(r);
        }
        System.out.println(sb.toString());
    }

    public static boolean minBacktracking(int depth) {
        if (depth == N+1) {
            if (isValid(minResult)) {
                return true;
            }
            return false;
        }

        for (int i=0; i<=9; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            minResult[depth] = i;
            if (minBacktracking(depth + 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static boolean maxBacktracking(int depth) {
        if (depth == N+1) {
            if (isValid(maxResult)) {
                return true;
            }
            return false;
        }

        for (int i=9; i>=0; i--) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            maxResult[depth] = i;
            if (maxBacktracking(depth + 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static boolean isValid(int[] result) {
        for (int i=0; i<result.length-1; i++) {
            char decision = arr[i];
            if (decision == '<') {
                if (result[i] > result[i+1]) {
                    return false;
                }
            }
            if (decision == '>') {
                if (result[i] < result[i+1]) {
                    return false;
                }
            }
        }
        return true;    
    }
}