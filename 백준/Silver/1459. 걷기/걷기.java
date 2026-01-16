import java.io.*;
import java.util.*;


// 3개의 케이스를 찾는다.
// 1) 직선이동
// 2) 최대한 대각 이동 + 직선 이동
// 3) 대각이동만 

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        // 직선 이동 케이스
        long sum1 = (n + m) * w;

        long sum2 = (Math.min(n, m) * s) + (Math.abs(n-m) * w);

        long sum3;
        if ((n+m) % 2 == 0) {
            sum3 = Math.max(n, m) * s;
        } else {
            sum3 = ((Math.max(n, m) - 1) * s) + w; 
        }
        System.out.println(Math.min(Math.min(sum1, sum2), sum3));
    }
}