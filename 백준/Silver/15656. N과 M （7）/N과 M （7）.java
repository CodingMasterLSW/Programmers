import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] tmpArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmpArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        backtracking(0);
        
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth) {
        // 종료 조건
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(tmpArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            tmpArr[depth] = arr[i];
            backtracking(depth + 1);
        }
    }
}