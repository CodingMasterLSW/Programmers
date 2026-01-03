import java.io.*;
import java.util.*;

class Main {

    static int T;
    static int N;
    static int M;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int z=0; z<T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new int[N];
            b = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            for (int i=0; i<M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int startIdx = b.length-1;
            int endIdx = a.length-1;
            int cnt = 0;
            int tmp = 0;

            Arrays.sort(a);
            Arrays.sort(b);

            while (endIdx > -1 && startIdx > -1) {
                if (a[endIdx] > b[startIdx]) {
                    cnt += startIdx+1;
                    endIdx--;
                } else if (a[endIdx] < b[startIdx]) {
                    startIdx--;
                } else {
                    startIdx--;
                }
            }
            System.out.println(cnt);
        }

    }
}