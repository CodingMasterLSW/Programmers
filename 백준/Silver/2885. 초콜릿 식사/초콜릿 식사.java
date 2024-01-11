import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int count;
    static int i;
    static int realCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());

        int i = 0;
        m = 1;
        while (n > Math.pow(2, i)) {
            if (n == Math.pow(2, i)) {
                m = (int) Math.pow(2, i - 1);
                break;
            }
            i++;
            m = (int) Math.pow(2, i);


        }

        if (m == n) {
            bw.write(String.valueOf(m) + " ");
            bw.write("0");
            bw.flush();
            bw.close();
        } else {
            int result = m / 2;
            int count = m / 2;

            while (true) {

                if (result == n) {
                    bw.write(String.valueOf(m) + " ");
                    bw.write(String.valueOf(realCount+1));
                    bw.flush();
                    bw.close();
                    break;
                } else if (result > n) {
                    count = count / 2;
                    result -= count;
                    realCount++;
                } else if (result < n) {
                    count = count / 2;
                    result += count;
                    realCount++;
                }

            }

        }

    }


}


