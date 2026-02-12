import java.io.*;
import java.util.*;

// 완탐 로직 하나
// 계산 로직 하나

class Main {

    static int T;
    static int N;
    static String[] arr = {" ", "+", "-"};
    static String[] current;
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            current = new String[N-1];
            backtracking(0);
            sb2.append("\n");
        }
        System.out.println(sb2.toString());
    }

    public static void backtracking(int depth) {
        if (depth == N-1) {
            String result = combine();
            int sum = calculate(result);
            if (sum == 0) {
                sb2.append(result).append("\n");
            }
            return;
        }

        for (int i=0; i<3; i++) {
            current[depth] = arr[i];
            backtracking(depth + 1);
        }
    }

    public static String combine() {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(String.valueOf(i));
            if (i != N) {
                sb.append(current[i-1]);
            }
        }
        return sb.toString();
    }

    public static int calculate(String result) {
        String newResult = result.replaceAll(" ", "");

        boolean isPlus = true;
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<newResult.length(); i++) {
            char c = newResult.charAt(i);
            if (c != '+' && c != '-') {
                sb.append(c);
                if (i == newResult.length() - 1) {
                    if (isPlus) {
                        sum += Integer.parseInt(sb.toString());
                    } else {
                        sum -= Integer.parseInt(sb.toString());
                    }
                }
                continue;
            }

            if (isPlus) {
                sum += Integer.parseInt(sb.toString());
            } else {
                sum -= Integer.parseInt(sb.toString());
            }
            sb.setLength(0);

            if (c == '+') {
                isPlus = true;
            } else if (c == '-') {
                isPlus = false;
            }
        }
        
        return sum;
    }
}