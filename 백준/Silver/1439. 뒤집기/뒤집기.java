import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int countZero = 0;
        int countOne = 0;

        if (s.charAt(0) == '0') {
            countZero ++;
        } else {
            countOne ++;
        }

        for (int i=1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                continue;
            } else {
                if (s.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }
        System.out.println(Math.min(countZero, countOne));
    }

}
