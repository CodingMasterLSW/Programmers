
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0; i<num; i++){
            int csum = 0;
            double gsum = 0;
            int num2 = sc.nextInt();
            for(int j=0; j<num2; j++){
                int c = sc.nextInt();
                double g = sc.nextDouble();
                csum+=c;
                gsum+=g*c;

            }
            System.out.println(csum+" "+Math.round(gsum*10.0/csum)/10.0);
        }

    }
}
