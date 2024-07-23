import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack1.push(s.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        int current = 0;

        while (current < N) {
            current++;
            String s1 = br.readLine();
            String[] split = s1.split(" ");

            if (split[0].equals("P")) {
                stack1.push(split[1].charAt(0));
            }
            if (split[0].equals("L")) {
                if (stack1.isEmpty()) {
                    continue;
                } else {
                    stack2.push(stack1.pop());
                }
            }
            if (split[0].equals("D")) {
                if (stack2.isEmpty()) {
                    continue;
                } else {
                    stack1.push(stack2.pop());
                }
            }

            if (split[0].equals("B")) {
                if (stack1.isEmpty()) {
                    continue;
                } else {
                    stack1.pop();
                }
            }

        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }
        System.out.println(sb.toString());

    }

}
