
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main  {

    public static void main(String[] args) throws IOException {
        int result = 0;

        Scanner sc = new Scanner(System.in);
        int kind = sc.nextInt();
        int money = sc.nextInt();

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < kind; i++) {
            int kindOfMoney = sc.nextInt();
            coins.add(kindOfMoney);
        }
        Collections.reverse(coins);

        while (true) {
            if (money == 0) {
                break;
            } else {
                for (int i = 0; i < coins.size(); i++) {
                    if (money / coins.get(i) >= 1) {
                        result += (money / coins.get(i));
                        money -= coins.get(i) * (money / coins.get(i));
                    }

                }

            }

        }
        System.out.println(result);

    }
}