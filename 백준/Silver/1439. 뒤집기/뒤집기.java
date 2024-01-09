import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] chars = input.toCharArray();
        int cntFirst = 0;
        int cntSecond = 0;
        char now = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != now) {
                now = chars[i];
                if (now == '0') {
                    cntFirst += 1;
                } else {
                    cntSecond += 1;
                }
            }
        }
        if(cntFirst>cntSecond){
            System.out.println(cntFirst);
        } else{
            System.out.println(cntSecond);
        }

    }

}
