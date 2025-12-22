import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static String[] guitar;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitar = new String[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            guitar[i] = st.nextToken();
        }
        
        int current = 1;
        int prevMaxCount = -1;
        
        while(true) {
            if (current > N) {
                if (maxCount == 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(current - 1);
                }
                break;
            }
            
            backtracking(0, 0, current);
            
            if (maxCount == prevMaxCount) {
                if (maxCount == 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(current -1);
                }
                break;
            }
            
            prevMaxCount = maxCount;
            current++;
        }
    }

    public static boolean backtracking(int depth, int start, int currentTracking) {
        if (depth == currentTracking) {
            List<String> currentGuitar = new ArrayList<>();
            for (int i=0; i<N; i++) {
                if (visited[i]) {
                    currentGuitar.add(guitar[i]);
                }
            }

            boolean[] canPlay = new boolean[M];

            for (String guitar :  currentGuitar) {
                for (int i=0; i<guitar.length(); i++) {
                    char play = guitar.charAt(i);
                    if (play == 'Y') {
                        canPlay[i] = true;
                    }
                }
            }
            
            int count = 0;
            for (int i=0; i<M; i++) {
                if (canPlay[i]) {
                    count++;
                }
            }
            
            maxCount = Math.max(maxCount, count);
            return false;
        }

        for (int i=start; i<N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            backtracking(depth+1, i+1, currentTracking);
            visited[i] = false;
        }
        return false;
    }
}