

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            int x = Math.abs(Integer.parseInt(br.readLine()));

            if (x == 0) {
                if (q.isEmpty()) {
                    bw.write(String.valueOf(0));
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(q.poll()));
                    bw.newLine();
                }
            } else {
                q.add(x);
            }
        }
        bw.flush();
        bw.close();
    }

}
