import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            List<Integer> prices = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                prices.add(Integer.parseInt(st.nextToken()));
            }
            bw.write(String.valueOf(calculateMax(prices)));
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }


    public static long calculateMax(List<Integer> prices) {

        int currentPrice = 0;
        long maxPrice = 0;

        for (int i = prices.size() - 1; i >= 0; i--) {
            if (prices.get(i) > currentPrice) {
                currentPrice = prices.get(i);
            } else {
                maxPrice += (long) currentPrice - prices.get(i);
            }
        }
        return maxPrice;
    }

}


