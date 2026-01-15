import java.io.*;

import java.util.*;

class Main {
    static int N;
    static List<Integer> arr = new ArrayList<>();
    static long sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        arr.sort(Comparator.reverseOrder());

        for (int i=0; i<N; i++) {
            if (arr.get(i) - i < 0) {
                break;
            } else {
                sum += arr.get(i) - i;
            }
        }

        System.out.println(sum);
    }
}