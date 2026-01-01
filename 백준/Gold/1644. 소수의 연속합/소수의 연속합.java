import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int[] arr = new int[4000005];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init();

        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        int cnt = 0;

        if (N == 2) {
            System.out.println(1);
            return;
        }

        while (true) {
            if (sum >= N) {
                if (sum == N) {
                    cnt++;
                }
                sum -= primes.get(startIdx);
                startIdx++;
            } else if (endIdx == primes.size()) {
                break;
            } else {
                sum += primes.get(endIdx);
                endIdx++;
            }
            
        }
        System.out.println(cnt);
    }

    public static void init() {
        for (int i=2; i<=N; i++) {
            arr[i] = i;
        }

        for (int i=2; i*i<=N; i++) {
            if (arr[i] == 0) {
                continue;
            }
            int count = 2;
            while (true) {
                int current = count * i;

                if (current > 4_000_000) {
                    break;
                } else {
                    arr[current] = 0;
                    count++;
                }
            }
        }

        for (int i=2; i<=4_000_000; i++) {
            if (arr[i] != 0) {
                primes.add(arr[i]);
            }
        }
    }


}