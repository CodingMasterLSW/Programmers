import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        PriorityQueue<Long> cards = new PriorityQueue<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cards.add(Long.parseLong(st2.nextToken()));
        }

        long finalResult = calculateResult(cards, m);
        bw.write(String.valueOf(finalResult));
        bw.flush();
        bw.close();
    }

    public static long calculateResult(PriorityQueue<Long> cards, int m) {
        for (int i = 0; i < m; i++) {
            long x = cards.poll(); // 가장 작은 카드
            long y = cards.poll(); // 두 번째로 작은 카드

            long sum = x + y;
            cards.add(sum);
            cards.add(sum);
        }

        long totalCount = 0;
        while (!cards.isEmpty()) {
            totalCount += cards.poll();
        }
        return totalCount;
    }
}