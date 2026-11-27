import java.io.*;
import java.util.*;

class Main {
    
    static boolean[] visited;
    static int N;
    static String S;
    static String sortS;
    static int result;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        N = S.length();
        char[] tmp = S.toCharArray();
        Arrays.sort(tmp);
        sortS = new String(tmp);
        visited = new boolean[N];
        dfs(0, 0);
        System.out.println(result);
    }

    public static boolean dfs(int current, int length) {
        if (N == length) {
            if (current > Integer.parseInt(S)) {
                result = current;
                return true;
            }
            return false;
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (dfs(current * 10 + sortS.charAt(i) - '0', length + 1)) {
                return true;
            } 
            visited[i] = false;
        }
        return false;

    }
}