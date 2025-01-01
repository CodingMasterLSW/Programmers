import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while((input = br.readLine()) != null) {
            sb = new StringBuilder();
            int N = Integer.parseInt(input);
            int length = (int) Math.pow(3, N);
            sb.append("-".repeat(length));
            cal(0, length);
            System.out.println(sb);
        }
    }

    public static void cal(int start, int length) {
        if (length == 1) {
            return;
        }

        int newStart = length / 3;

        for (int i = start + newStart; i < start + 2 * newStart; i++) {
            sb.setCharAt(i, ' ');
        }
        cal(start, newStart);
        cal((start + 2 * newStart), newStart);
    }

}
