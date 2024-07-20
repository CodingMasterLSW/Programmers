import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] roadLength = new long[N-1];
        int[] city = new int[N];

        for(int i=0; i<roadLength.length; i++){
            roadLength[i] = sc.nextLong();
        }

        for(int i=0; i<city.length; i++){
            city[i] = sc.nextInt();
        }

        int currentMin = 0;
        int idx = 0;
        long result = 0;

        result += (city[idx] * roadLength[idx]);
        currentMin = city[idx];
        idx++;

        while(idx<N-1){

            if(city[idx]< currentMin){
                currentMin = city[idx];
                result += currentMin * roadLength[idx];
            } else{
                result += currentMin * roadLength[idx];
            }
            idx++;
        }
        System.out.println(result);
    }

}
