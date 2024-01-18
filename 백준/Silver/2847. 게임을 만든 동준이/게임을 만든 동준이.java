import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int cnt = 0;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        List<Integer> scores = new ArrayList<>();
        for(int i=0; i<k; i++){
            scores.add(Integer.parseInt(br.readLine()));
        }
        calculateResult(scores);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();


    }

    public static void calculateResult(List<Integer> scores) {

        maxScore = scores.get(scores.size() - 1);

        for (int i = scores.size() - 2; i >= 0; i--) {
            int currentScore = scores.get(i);

            while (true) {
                if (currentScore >= maxScore) {
                    currentScore -= 1;
                    cnt += 1;
                } else {
                    maxScore = currentScore;
                    break;
                }

            }
        }
    }

}
