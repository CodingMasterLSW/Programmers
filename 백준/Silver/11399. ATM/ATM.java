
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> lists = new ArrayList<>();
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        for (int i = 0; i < people; i++) {
            lists.add(sc.nextInt());
        }
        int currentNum = 0;
        Collections.sort(lists);

        for (Integer list : lists) {
            currentNum += list;
            result += currentNum;

        }
        System.out.println(result);

    }

}


