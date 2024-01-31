

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();

        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        while(q.size()>1){
            q.poll();
            Integer peek = q.peek();
            q.offer(peek);
            q.poll();

        }
        System.out.println(q.peek());
    }

}
