import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> ropes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        for(int i=0; i<line; i++){
            ropes.add(sc.nextInt());
        }
        Collections.sort(ropes);
        int max = 0;

        for(int i=0; i<ropes.size(); i++){
            if(ropes.get(i)*(ropes.size()-i)>=max){
                max = ropes.get(i)*(ropes.size()-i);
            }
        }
        System.out.println(max);

    }

}
