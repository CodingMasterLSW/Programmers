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
            String target = String.valueOf(dp[i-1]);
            int sum = 0;
            
            for (char t : target.toCharArray()) {
                int value = t - '0';
                sum += (int) Math.pow(value, P);
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
// 나머지 연산으로 하는 코드도 이후에 짜보자.