import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0;
        boolean isContainsZero = false;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            if (s.charAt(i) == '0') {
                isContainsZero = true;
            }
        }
        if (!isContainsZero || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            char[] digits = s.toCharArray();
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder();
            sb.append(digits);
            sb.reverse().toString();
            System.out.println(sb);
        }


    }

}
