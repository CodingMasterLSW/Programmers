import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int changeInput = Integer.parseInt(input);

        for (int i = 0; i < changeInput; i++) {
            int finalResult = i + calculateResult(i);
            if (finalResult == changeInput) {
                System.out.println(i);
                break;
            }
            if(i==changeInput-1){
                System.out.println(0);
            }
        }
    }

    // i 들어왔을 때 계산 로직
    private static int calculateResult(int k) {
        int result = 0;
        String changeK = String.valueOf(k);
        for (char c : changeK.toCharArray()) {
            result += Integer.parseInt(Character.toString(c));
        }
        return result;

    }
}

