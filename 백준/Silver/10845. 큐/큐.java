

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            String input = br.readLine();

            if(input.contains("push")){
                String[] splitInput = input.split(" ");
                q.offer(Integer.parseInt(splitInput[1]));
            }
            else if(input.equals("pop")){
                pop();
            }
            else if(input.equals("size")){
                size();
            }
            else if(input.equals("empty")){
                empty();
            }
            else if(input.equals("front")){
                front();
            }
            else if(input.equals("back")){
                back();
            }
        }

    }

    static void pop(){
        if(q.isEmpty()){
            System.out.println(-1);
        } else{
            System.out.println(q.poll());
        }
    }

    static void size() {
        System.out.println(q.size());
    }

    static void empty() {
        if (q.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void front() {
        if (q.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(q.peek());
        }
    }

    static void back() {

        if (q.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Queue<Integer> q2 = new LinkedList<>(q);

        while (q2.size() > 1) {
            q2.poll();
        }
        System.out.println(q2.peek());
    }

    static void push(int x) {
        q.offer(x);
    }


}
