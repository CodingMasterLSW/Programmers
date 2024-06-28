import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int z = 0; z < T; z++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] apartment = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                apartment[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
                }
            }
            System.out.println(apartment[k][n]);

        }
    }

}
