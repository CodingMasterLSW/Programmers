import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int cnt;

    public static void main(String[] args) {

        List<Integer> lists = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int m = sc.nextInt();
            lists.add(m);
        }

        for (Integer list : lists) {
            int checkSum = 0;
            for (int i = 1; i <= list; i++) {
                if (list % i == 0) {
                    checkSum += 1;
                }
            }
            if (checkSum == 2) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }

}
