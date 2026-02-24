import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] a = new int[35];
        int[] b = new int[35];

        a[1] = 1;
        a[2] = 0;
        a[3] = 1;
        a[4] = 1;

        for (int i=5; i<=30; i++) {
            a[i] = a[i-1] + a[i-2];
        }

        b[1] = 0;
        b[2] = 1;
        b[3] = 1;
        for (int i=4; i<=30; i++) {
            b[i] = b[i-1] + b[i-2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int v1 = a[x];
        int v2 = b[x];

        int k = 1;
        while(true) {
            int target = y - (v1 * k);
            if (target % v2 == 0) {
                System.out.println(k);
                System.out.println(target / v2);
                break;
            }
            k++;
        }
    }
}