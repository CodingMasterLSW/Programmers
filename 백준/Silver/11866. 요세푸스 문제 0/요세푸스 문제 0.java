

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<Integer> lists = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                q.add(q.poll());
            }
            lists.add(q.poll());
        }
        System.out.print("<");

        for (int i = 0; i < lists.size(); i++) {
            if (i == lists.size()-1) {
                System.out.print(lists.get(i));
            } else{
                System.out.print(lists.get(i) + ", ");
            }
        }
        System.out.println(">");
    }

}

