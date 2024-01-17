import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int resultM = 1;
    static int resultN = 1;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());
        n = Integer.parseInt(st1.nextToken());

        for (int i=0; i<n; i++) {
            resultM *= m;

            m--;
        }
        for(int i=1; i<n+1; i++){
            resultN*=i;
        }
        int finalResult = resultM/resultN;
        bw.write(String.valueOf(finalResult));
        bw.flush();
        bw.close();
    }

}