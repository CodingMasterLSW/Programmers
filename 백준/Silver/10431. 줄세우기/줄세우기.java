import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int z = 0; z < k; z++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            st1.nextToken();

            int[] arr = new int[20];

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st1.nextToken());
            }

            int cnt = 0;

            for (int i = 0; i < 20; i++) {

                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        cnt++;
                    }
                }
            }
            System.out.print((z+1)+" ");
            System.out.println(cnt);
        }
    }
}
