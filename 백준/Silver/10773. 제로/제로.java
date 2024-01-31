

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<k; i++){
            int input = sc.nextInt();
            if(input==0){
                stack.pop();
            } else{
                stack.push(input);
            }
        }
        int sum =0;

        for(int i : stack){
            sum += i;
        }
        System.out.println(sum);
    }


}
