import java.io.*;
import java.util.*;

class Main {

    static Map<Integer, Integer> maps = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] dp = new int[10005];

        dp[1] = A;
        maps.put(dp[1], 1);

        for (int i=2; i<=10_000; i++) {
            int target = dp[i-1];

            int sum = 0;

            while (target > 0) {
                int digit = target % 10;
                sum += Math.pow(digit, P);
                target /= 10;
            }
            dp[i] = sum;
            maps.put(dp[i], maps.getOrDefault(dp[i], 0) + 1);
        }

        int cnt = 0;
        for (int key : maps.keySet()) {
            if (maps.get(key) > 1) {
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
