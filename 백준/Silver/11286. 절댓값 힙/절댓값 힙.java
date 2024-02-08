

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
        int absCompare = Integer.compare(Math.abs(a), Math.abs(b));
        if (absCompare == 0) {
            return Integer.compare(a, b);
        } else {
            return absCompare;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());

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
