

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();


        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());

        int count = 1;
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            map1.put(input, count);
            map2.put(count, input);
            count++;
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (isInteger(input)) {
                bw.write(map2.get(Integer.parseInt(input)));
                bw.newLine();
            } else {
                bw.write(String.valueOf(map1.get(input)));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
