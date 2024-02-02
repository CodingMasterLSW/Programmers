
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());

        int[][] dot = new int[k][2];

        for (int i = 0; i < k; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                dot[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        Arrays.sort(dot, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int i=0; i<k; i++){
            for(int j=0; j<2; j++){
                bw.write(String.valueOf(dot[i][j]+" "));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
