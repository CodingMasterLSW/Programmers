import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int result = 0;

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            int number = i;
            int calculateResult = 0;

            while (number != 0) {
                calculateResult += (number % 10);
                number /= 10;
            }

            if (input == i + calculateResult) {
                result = i;
                break;
            }

        }
        System.out.println(result);

    }


}
