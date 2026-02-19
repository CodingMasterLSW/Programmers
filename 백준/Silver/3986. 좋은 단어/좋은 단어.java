// stack 
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i=0; i<N; i++) {
            Deque<Character> deq = new ArrayDeque<>();
            String input = br.readLine();

            for (char c : input.toCharArray()) {
                if (deq.isEmpty()) {
                    deq.push(c);
                    continue;
                }

                if (deq.peek() == c) {
                    deq.pop();
                } else {
                    deq.push(c);
                }
            }
            if (deq.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}