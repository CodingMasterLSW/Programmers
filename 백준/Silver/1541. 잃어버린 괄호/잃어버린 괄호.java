import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> lists = new ArrayList<>();
        String input = sc.next();
        String[] split = input.split("-");
        int total = 0;

        String[] initialNumbers = split[0].split("\\+");
        for (String number : initialNumbers) {
            total += Integer.parseInt(number);
        }

        for (int i = 1; i < split.length; i++) {
            String[] numbers = split[i].split("\\+");
            for (String number : numbers) {
                total -= Integer.parseInt(number);
            }
        }
        System.out.println(total);

    }


}




