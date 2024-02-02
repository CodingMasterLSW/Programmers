
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<Integer, Boolean> maps = new HashMap<>();
        List<Integer> lists = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st1.nextToken());
            maps.put(k, true);
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st2.nextToken());
            if (maps.containsKey(k)) {
                bw.write(String.valueOf(1));
            } else {
                bw.write(String.valueOf(0));
            }
            bw.newLine();

        }
        bw.flush();
        bw.close();

    }
}
