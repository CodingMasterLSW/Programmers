import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] area = new int[100][100];

        for(int c=0; c<4; c++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int i = x1; i < x2; i++) {

                for (int j = y1; j < y2; j++) {
                    area[i][j] = 1;
                }
            }
        }
        int result = 0;

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(area[i][j] == 1){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
