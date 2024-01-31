
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.contains("push_back")) {
                String[] splitInput = input.split(" ");
                pushBack(Integer.parseInt(splitInput[1]));
            }
            if (input.contains("push_front")) {
                String[] splitInput = input.split(" ");
                pushFront(Integer.parseInt(splitInput[1]));
            }
            if (input.equals("back")) {
                back();
            }
            if (input.equals("front")) {
                front();
            }
            if (input.equals("empty")) {
                empty();
            }
            if (input.equals("size")) {
                size();
            }
            if (input.equals("pop_front")) {
                popFront();
            }
            if (input.equals("pop_back")) {
                popBack();
            }

        }
    }

    static void pushFront(int x) {
        dq.addFirst(x);
    }

    static void pushBack(int x) {
        dq.addLast(x);
    }

    static void popFront() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.removeFirst());
    }

    static void popBack() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.removeLast());

    }

    static void size() {
        System.out.println(dq.size());
    }

    static void empty() {
        if (dq.isEmpty()) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    static void front() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.getFirst());
    }

    static void back() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.getLast());
    }
}
