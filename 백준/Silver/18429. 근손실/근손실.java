import java.io.*;
import java.util.*;


// 운동 키트 : N일동안 1번만 사용 
// 모든 경우의 수를 출력하라
// 순서 상관O, 순열 -> visited 배열 사용하기 

class Main {

    static int cnt;
    static boolean[] visited;
    static int[] tmp;
    static int[] arr;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N];
        arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(cnt);

    }

    public static void dfs(int length) {
        if (N == length) {
            if (check()) {
                cnt++;
            }
            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tmp[length] = i;
            dfs(length + 1);
            visited[i] = false;
        }
    }

    public static boolean check() {
        int value = 500;

        for (int i=0; i<arr.length; i++) {
            value -= K;
            
            int t = tmp[i]; // 2, 1, 3 -> 2를 먼저 가져와 
            int v = arr[t]; 
            value +=v; 
            if (value < 500) {
                return false;
            }
        }
        return true;
    }
}

