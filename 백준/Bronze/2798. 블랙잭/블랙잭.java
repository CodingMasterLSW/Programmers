
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> lists = new ArrayList<>();
    static int n;
    static int m;
    static int currentClose = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<n; i++){
            lists.add(sc.nextInt());
        }

        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = lists.get(i) + lists.get(j) + lists.get(k);
                    if(sum>currentClose && sum<=m){
                        currentClose = sum;
                    }
                }
            }
        }
        System.out.println(currentClose);
    }

}
