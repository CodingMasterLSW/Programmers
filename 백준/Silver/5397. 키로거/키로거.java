import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int z=0; z<N; z++) {
            String s = br.readLine();
            
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (int i=0; i < s.length(); i++) {
                char current = s.charAt(i);

                if (current == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    continue;
                }

                if (current == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    continue;
                }

                if (current == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    continue;
                }
                left.push(current);
            }

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                sb.append(left.pollLast());
            }
            while (!right.isEmpty()) {
                sb.append(right.pollFirst());
            }
            System.out.println(sb.toString());
        }
    }
}