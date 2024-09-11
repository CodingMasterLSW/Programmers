import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long current = 0;
        long idx = 1;
        while (current + idx <= S) {
            current += idx;
            idx++;
        }
        System.out.println(idx -1);
    }

}