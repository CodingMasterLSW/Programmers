import java.io.*;
import java.util.*;

class Main {

    static boolean[] isPrime = new boolean[10001];
    static List<Integer> primes = new ArrayList<>();   
    static boolean[] visited = new boolean[10001];

    static int N;
    static int start;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Arrays.fill(isPrime, true);

        for (int i=2; i * i <= 10_000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 10_000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i=2; i<= 10_000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }


        for (int i=0; i<N; i++) {
            visited = new boolean[10001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            int result = bfs(new int[]{start, 0});
            if (result == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(result);
            }
        }
        
        for (int i=1000; i<=10_000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
    }

    public static int bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int value = current[0];
            int cnt = current[1];

            if (value == target) {
                return cnt;
            }

            char[] chars = String.valueOf(value).toCharArray();

            for (int i=0; i<chars.length; i++) {
                char original = chars[i];

                for (int j=0; j<10; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    chars[i] = String.valueOf(j).charAt(0);
                    int convertValue = Integer.parseInt(new String(chars));

                    //System.out.println("convertValue = " + convertValue);
                    if (primes.contains(convertValue) && !visited[convertValue]) {
                        visited[convertValue] = true;
                        // System.out.println();
                        // System.out.println("convertValue 삽입 :" + convertValue);
                        q.offer(new int[]{convertValue, cnt + 1});
                    }
                }
                chars[i] = original;
            }
        }
        return -1;
    }
}