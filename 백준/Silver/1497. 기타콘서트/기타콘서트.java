import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static String[] guitars;
    static int targetCount = 0;
    static boolean[] visitedGuitar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitars = new String[N];
        visitedGuitar = new boolean[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            guitars[i] = st.nextToken();
        }
        
        boolean[] canPlay = new boolean[M];
       
        // targetCount 초기화
        for (int i=0; i<N; i++) {
            String guitar = guitars[i];
            for (int j=0; j<M; j++) {
                if (guitar.charAt(j) == 'Y') {
                    canPlay[j] = true;
                }
            }
        }

        for (int i=0; i<M; i++) {
            if (canPlay[i]) {
                targetCount ++;
            }
        }
        // 아무것도 없는 경우
        if (targetCount==0) {
            System.out.println("-1");
            return;
        }

        int currentDepth = 1;
        while (true) {

            boolean result = backtracking(0, 0, currentDepth);
            if (result) {
                System.out.println(currentDepth);
                break;
            } else {
                currentDepth ++;
            }
        }
    
    }

    public static boolean backtracking(int depth, int start, int currentDepth) {
        // 종료 조건
        // 여기서 visited 계산 후, targetCount와 같은지 비교한다
        // 같으면 true, 아니면 false를 반환한다.
        if (currentDepth == depth) {
            boolean[] tmpCanPlay = new boolean[M];
            for (int i=0; i<N; i++) {
                if (visitedGuitar[i]) {
                    String current = guitars[i];
                    for (int j=0; j<M; j++) {
                        if (current.charAt(j) == 'Y') {
                            tmpCanPlay[j] = true;
                        }
                    }
                    
                }
            }
            int tmpCount = 0;
                for (int j=0; j<M; j++) {
                    if (tmpCanPlay[j]) {
                        tmpCount++;
                    }
                }
                if (tmpCount== targetCount) {
                    return true;
                }  
        return false;
        }

        for (int i=start; i<N; i++) {
            visitedGuitar[i] = true;
            if (backtracking(depth+1, i+1, currentDepth)) {
                return true;
            }
            visitedGuitar[i] = false;
        }
        return false;
    }
}