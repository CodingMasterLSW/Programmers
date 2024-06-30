import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] A = new int[N][M];


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                A[i][j] = sc.nextInt();
            }
        }
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[][] B = new int[X][Y];

        for(int i=0; i<X; i++){
            for(int j=0; j<Y; j++){
                B[i][j] = sc.nextInt();
            }
        }
        int[][] AB = new int[N][Y];

        for(int i=0; i<N; i++){
            for(int j=0; j<Y; j++){
                for(int k=0; k<M; k++){
                    AB[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<Y; j++){
                System.out.print(AB[i][j]+ " ");
            }
            System.out.println();
        }

    }

}
