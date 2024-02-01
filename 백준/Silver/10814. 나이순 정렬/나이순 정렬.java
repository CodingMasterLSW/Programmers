

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < k; i++) {
            String input = sc.nextLine();
            lists.add(input);
        }

        Collections.sort(lists, (a,b) -> {
            int ageA = Integer.parseInt(a.split(" ")[0]);
            int ageB = Integer.parseInt(b.split(" ")[0]);
            return ageA-ageB;
        });

        for(String i : lists){
            System.out.println(i);
        }

    }

}
