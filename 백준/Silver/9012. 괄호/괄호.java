
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<k; i++){

            int balance = 0;
            String input =  sc.nextLine();

            for(char c : input.toCharArray()){
                if(c=='('){
                    balance ++;
                } else if(c==')'){
                    balance --;
                }
                if (balance<0){
                    break;
                }
            }
            if(balance==0){
                System.out.println("YES");
            } else{
                System.out.println("NO");

            }
        }
    }
}
