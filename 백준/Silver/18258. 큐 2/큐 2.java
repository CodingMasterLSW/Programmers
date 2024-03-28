
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // StringBuilder를 생성합니다.
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.contains("push")) {
                String[] inputSplit = input.split(" ");
                push(Integer.parseInt(inputSplit[1]));
            } else if (input.contains("front")) {
                front(sb);
            } else if (input.contains("back")) {
                back(sb);
            } else if (input.contains("size")) {
                size(sb);
            } else if (input.contains("empty")) {
                empty(sb);
            } else if (input.contains("pop")) {
                pop(sb);
            }
        }
        System.out.println(sb.toString()); // 마지막에 모아둔 결과를 한 번에 출력합니다.
    }

    static void push(int x) {
        dq.offer(x);
    }

    static void front(StringBuilder sb) {
        if (dq.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(dq.getFirst()).append("\n");
        }
    }

    static void pop(StringBuilder sb) {
        if (dq.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(dq.pop()).append("\n");
        }
    }

    static void size(StringBuilder sb) {
        sb.append(dq.size()).append("\n");
    }

    static void back(StringBuilder sb) {
        if (dq.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(dq.getLast()).append("\n");
        }
    }

    static void empty(StringBuilder sb) {
        if (dq.isEmpty()) {
            sb.append("1\n");
        } else{
            sb.append("0\n");
        }
    }
}