

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            String input = br.readLine();
            if(input.contains("push")){
                String[] split = input.split(" ");
                push(Integer.parseInt(split[1]));

            } else if(input.equals("size")){
                size();
            } else if(input.equals("top")){
                top();
            } else if(input.equals("empty")){
                empty();
            } else if (input.equals("pop")) {
                pop();
            }

        }
    }
    static void size(){
        System.out.println(stack.size());
    }

    static void empty(){
        if(stack.isEmpty()){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
    static void top(){
        if(stack.isEmpty()){
            System.out.println(-1);
        } else{
            System.out.println(stack.peek());
        }
    }

    static void pop(){
        if(stack.isEmpty()){
            System.out.println(-1);
        } else{
            System.out.println(stack.pop());
        }
    }

    static void push(int x){
        stack.push(x);
    }

}
