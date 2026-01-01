import java.io.*;
import java.util.*;

class Main {

    static int[] arr = new int[4000005];
    static int N;
    static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        init();
        
        int startIdx = 0;
        int endIdx = 0;
        
        int sum = 0;
        int count = 0;

        while(startIdx < prime.size() && prime.get(startIdx) <= N) {
            if (sum <= N && endIdx < prime.size()) {
                sum += prime.get(endIdx);
                endIdx ++;
                if (sum == N) {
                    count++;
                }

            } else if (sum > N) {
                while (true) {
                    if (sum <= N) {
                        if (sum == N) {
                            count++;
                        }
                        break;
                    }
                    sum -= prime.get(startIdx);
                    //System.out.println("sum = " + sum);

                    startIdx++;
                }
            } else {
                break;
            }
            //System.out.println("sum = " + sum);
        }
        System.out.println(count);
    }

    public static void init() {
        for (int i=2; i<= 4_000_000; i++) {
            arr[i] = i;
        }
        
        for (int i=2; i*i<=4_000_000; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i+i; j <= 4_000_000; j+=i) {
                arr[j] = 0;
            }
            
        }

        for (int i=1; i<=4_000_000; i++) {
            if (arr[i] != 0) {
                prime.add(arr[i]);
            }
        }
    }
}