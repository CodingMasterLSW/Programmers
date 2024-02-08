

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {

            Map<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String category = input[1];

                map.put(category, map.getOrDefault(category,0)+1);
            }
            int result = 1;

            for(int count : map.values()){
                result *= count+1;
            }
            result -=1;

            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }



}
