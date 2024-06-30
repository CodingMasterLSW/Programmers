

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] array = new int[N+1][M+1];

        for(int i=1; i<=N; i++){

            for(int j=1; j<=M; j++){
                int num = sc.nextInt();
                array[i][j] = num;
            }
        }

        int count = sc.nextInt();
        for(int c=0; c<count; c++){
            int sum = 0;

            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int i=x1; i<=y1; i++){

                for(int j=x2; j<=y2; j++){
                    sum+= array[i][j];
                }
            }
            System.out.println(sum);

        }
    }

}
