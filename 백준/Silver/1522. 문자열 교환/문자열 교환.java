import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String target = sb.append(s).append(s).toString();

        int minValue = Integer.MAX_VALUE;

        int startIdx = 0;

        int endIdx = -1;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'a') {
                endIdx++;
            }
        }

        if (endIdx == -1) {
            System.out.println(0);
            return;
        }

        while (endIdx < target.length()) {

            int cnt = 0;
            for (int i=startIdx; i<=endIdx; i++) {
                if (target.charAt(i) == 'b') {
                    cnt++;
                }
            }
            minValue = Math.min(cnt, minValue);
            startIdx++;
            endIdx++;
        }
        System.out.println(minValue);
    }
}