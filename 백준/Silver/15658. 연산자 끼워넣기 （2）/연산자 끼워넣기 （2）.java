import java.io.*;
import java.util.*;

// 연산자는 N-1보다 많을 수 있음
// 계산의 순서는 무조건 앞에서부터 (연산자 우선순위 무시)

// 최솟값, 최댓값을 둘 다 구해야하니깐 결국 연산자를 다 쓰는 완탐을 해야함.

// {+, -, /, /, *} -> 

// 1) 완탐으로 모든 경우의 수 탐색
// 2) 계산 로직

class Main {

    static int[] arr;
    static int[] count = new int[4];
    static int[] tmp;
    static int N;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(maxValue);
        System.out.println(minValue);
        
    }

    public static void dfs(int length) {
        // 종료 조건 
        if (N-1 == length) {
            int value = cal();
            maxValue = Math.max(value, maxValue);
            minValue = Math.min(value, minValue);
            return;
        }

        for (int i=0; i<4; i++) {
            if (count[i] < 1) {
                continue;
            }
            count[i] --;
            tmp[length] = i;
            dfs(length + 1);
            count[i] ++;
        }
    }

    public static int cal() {
        int value = arr[0];

        for (int i=0; i<N-1; i++) {
            int next = arr[i+1];

            if (tmp[i] == 0) {
                value += next;
            } else if (tmp[i] == 1) {
                value -= next;
            } else if (tmp[i] == 2) {
                value *= next;
            } else if (tmp[i] == 3) {
                value /= next;
            }
        }
        return value;

    }
}