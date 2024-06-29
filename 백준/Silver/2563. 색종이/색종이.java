import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] canvas = new int[100][100];

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();


            for(int m = x; m<x+10; m++){

                for(int n = y; n<y+10; n++){
                    canvas[m][n] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(canvas[i][j]==1){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }

}
