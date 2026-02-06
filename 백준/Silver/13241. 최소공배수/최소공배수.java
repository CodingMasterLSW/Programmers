import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long max = Math.max(a, b);
        long min = Math.min(a, b);

        long cal = recursion(max, min);
        System.out.println(a * b /cal);
    }

    public static long recursion(long x, long y) {
        long newY = x % y;

        if (newY == 0) {
            return y;
        } else {
            return recursion(y, newY);
        }
    }
}