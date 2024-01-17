import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());

        int min = 0;
        for (int i = 1; i <= Math.min(m, n); i++) {
            if (m % i == 0 && n % i == 0) {
                min = i;
            }
        }
        int lcm = Math.max(m, n);
        while (lcm % m != 0 || lcm % n != 0) {
            lcm += min;
        }

        bw.write(String.valueOf(min));
        bw.newLine();
        bw.write(String.valueOf(lcm));
        bw.flush();
        bw.close();

    }
}
