import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = 1;

        for(int i=0; i<num; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(result == a)
                result = b;
            else if(result == b)
                result = a;

        }
        System.out.println(result);
    }
}