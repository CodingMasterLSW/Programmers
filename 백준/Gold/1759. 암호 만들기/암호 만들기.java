import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;

    static char[] arr; 
    static char[] result;
    static StringBuilder sb = new StringBuilder();
    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M];
        result = new char[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth, int start) {
        // 종료 조건
        if (depth == N) {
            int vowelCnt = 0;
            int conCnt = 0;
            for (int i=0; i<N; i++) {
                if (vowels.contains(result[i])) {
                    vowelCnt++; 
                } else {
                    conCnt ++;
                }
            }
        
            if (vowelCnt < 1 || conCnt < 2) {
                return;
            } 

            for (int i=0; i<N; i++) {
                sb.append(result[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<M; i++) {

            result[depth] = arr[i];
            backtracking(depth + 1, i+1);
        }
    
    }
}