import java.io.*;
import java.util.*;

class Main {

    static List<String> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            arr.add(s);
        }

        Collections.sort(arr, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            int aSum = 0;
            int bSum = 0;
            for (int i=0; i<a.length(); i++) {
                if (Character.isDigit(a.charAt(i))) {
                    aSum += a.charAt(i) - '0';
                }
                if (Character.isDigit(b.charAt(i))) {
                    bSum += b.charAt(i) - '0';
                }
            }

            if (aSum != bSum) {
                return aSum - bSum;
        
            } else {
                int cnt = 0;
                while(true) {
                    char target1 = a.charAt(cnt);
                    char target2 = b.charAt(cnt);

                    if (target1 != target2) {
                        return target1 - target2;
                    } else {
                        cnt++;
                    }
                }
            }
            
        });

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());

    }
}