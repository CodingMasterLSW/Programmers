import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] result = new int[6]; //[0, 0, 0, 0, 0, 0]
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            arr = new int[N];
            visited = new boolean[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
        // while (true) {
        //     st = new StringTokenizer(br.readLine());
        //     N = Integer.parseInt(st.nextToken());
        //     if (N == 0) {
        //         break;
        //     }

        //     arr = new int[N]; // [0, 0, 0, 0, 0, 0, 0]
        //     visited = new boolean[N]; // [false, false, false, false, false, false, false]
        //     for (int i=0; i<N; i++) {
        //         arr[i] = Integer.parseInt(st.nextToken());
        //     }
        //     backtracking(0);
        //     sb.append("\n");
        // }
        // System.out.println(sb.toString());
    }

    public static void backtracking(int depth, int start) {
        if (depth == 6) {
            for (int i=0; i<6; i++) {
                sb.append(result[i] + " ");
            }   
            sb.append("\n");
            return;
        }

        for (int i=start; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}