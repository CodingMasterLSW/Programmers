import java.io.*;
import java.util.*;

class Main {

    static int T;
    static boolean[] isPrime = new boolean[1000001];
    static List<Integer> primes = new ArrayList<>();
    static int N;
    static int cnt;

    static int[] arr = new int[2];

    public static void main(String[] args) throws IOException {
        Arrays.fill(isPrime, true);
        for (int i=2; i * i<=1_000_000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1_000_000; j += i) {
                    isPrime[j] = false;
                }
            }
            
        }

        for (int i=2; i<=1_000_000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int z=0; z<T; z++) {
            N = Integer.parseInt(br.readLine());
            int startIdx = 0;
            int endIdx = 0;
            for (int i=0; i<primes.size(); i++) {
                if (primes.get(i) >= N) {
                    endIdx = i-1;
                    break;
                }
            }
            int cnt = 0;

            while (startIdx <= endIdx) {
                int sum = primes.get(startIdx) + primes.get(endIdx);
                if (sum > N) {
                    endIdx--;
                } else if (sum < N) {
                    startIdx++;
                } else if (sum == N) {
                    cnt++;
                    startIdx++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

}