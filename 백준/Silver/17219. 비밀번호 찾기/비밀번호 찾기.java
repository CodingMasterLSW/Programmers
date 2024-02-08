
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
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());

        Map<String, String> map = new HashMap<>();

        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");
            map.put(input[0],input[1]);
        }

        for(int i=0; i<n; i++){
            bw.write(map.get(br.readLine()));
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

}
