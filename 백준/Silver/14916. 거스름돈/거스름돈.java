import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            if (N % 5 == 0) {
                N -= 5;
                count++;
            } else {
                N -= 2;
                count++;
            }
        }
        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

}
