import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] bucket = new int[N+1];

        for(int i=1; i<=N; i++){
            bucket[i] = i;
        }

        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int currentX = bucket[x];
            int currentY = bucket[y];

            bucket[x] = currentY;
            bucket[y] = currentX;

        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(bucket[i]+" ");
        }
        System.out.println(sb.toString().trim());

    }

}
