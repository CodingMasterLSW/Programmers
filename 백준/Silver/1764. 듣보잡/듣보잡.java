
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static List<String> lists = new ArrayList<>();
    static Map<String, Boolean> map = new HashMap<>();

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                lists.add(input);
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.newLine();
        
        Collections.sort(lists);
        for (String list : lists) {
            bw.write(String.valueOf(list));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
