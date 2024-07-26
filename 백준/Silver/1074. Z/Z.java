import java.io.*;
import java.util.*;

public class Main {

    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int current = (int) Math.pow(2,N);

        find(current, r, c);
        System.out.println(res);

    }
    public static void find(int current, int r, int c) {

        if(current == 1){
            return;
        }

        int half = current /2;
        int area = half * half;

        // 좌상단
        if(r<half && c < half){
            find(half, r, c);
        }
        // 우상단
        else if (r<half && c>=half) {
            res += area;
            find(half, r, c-half);
        }

        // 좌하단
        else if (r >= half  && c < half) {
            res += 2 * area;
            find(half, r-half, c);
        }
        //4사분면
        else if (r >= half && c >= half) {
            res += 3 * area;
            find(half, r - half, c - half);
        }
    }
}
