import java.io.*;
import java.util.*;

class Main {

    static int[] dp = new int[46];
    static Deque<Integer> deq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i=2; i<=45; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int target = Integer.parseInt(br.readLine());
            recursion(target);
            StringBuilder sb = new StringBuilder();
            while (!deq.isEmpty()) {
                sb.append(deq.pop()).append(" ");
            }
            System.out.println(sb.toString());
        }

    }

    public static void recursion(int target) {
        int idx = findMax(target);
        int leftValue = target - dp[idx];
        deq.push(dp[idx]);
        if (leftValue == 0) {
            return;
        }
        recursion(leftValue);
    }

    public static int findMax(int target) {
        int idx = 0;
        while(true) {
            if (target < dp[idx]) {
                return idx - 1;
            }
            idx++;
        }
    }
}