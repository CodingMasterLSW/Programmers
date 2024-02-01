
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

        int k = Integer.parseInt(br.readLine());
        Map<Integer,Integer> cardCounts = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<k; i++){
            int num = Integer.parseInt(st.nextToken());
            cardCounts.put(num, cardCounts.getOrDefault(num, 0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            bw.write(cardCounts.getOrDefault(num, 0)+ " ");
        }

        bw.flush();
        bw.close();
    }

}
