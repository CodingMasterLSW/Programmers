import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // arr 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0], 0);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) {
        if (idx+1 == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i=0; i<4; i++) {
            if (operator[i] > 0) {
                operator[i] --;
                switch (i) {
                    case 0 : dfs(num + arr[idx+1], idx+1); break;
                    case 1 : dfs(num - arr[idx+1], idx+1); break;
                    case 2 : dfs(num * arr[idx+1], idx+1); break;
                    case 3 : dfs(num / arr[idx+1], idx+1); break;
                }
                operator[i] ++;
            }
        }
    }
}
