import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        char[][] graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String k = sc.nextLine();
            char[] array = k.toCharArray();

            for (int j = 0; j < N; j++) {
                graph[i][j] = array[j];
            }
        }
        int[] heart = findHeart(graph);
        int leftArm = findLeftArm(heart, graph);
        int rightArm = findRightArm(heart, graph);
        int waist = findWaist(heart, graph);
        int leftLeg = findLeftLeg(heart, graph, waist);
        int rightLeg = findRightLeg(heart, graph, waist);

        System.out.println(heart[0] + " " + heart[1]);
        System.out.print(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);


    }

    private static int[] findHeart(char[][] graph) {
        int[] heart = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == '*') {
                    heart[0] = i + 2;
                    heart[1] = j + 1;
                    return heart;
                }
            }
        }
        return heart;
    }

    private static int findLeftArm(int[] heart, char[][] graph) {
        int leftArm = 0;
        int x = heart[0] - 1;
        int y = heart[1] - 1;

        while (x < N - 1 && y < N - 1 && x > 0 && y > 0 && graph[x][y - 1] == '*') {
            y--;
            leftArm++;
        }
        return leftArm;
    }

    private static int findRightArm(int[] heart, char[][] graph) {
        int rightArm = 0;
        int x = heart[0] - 1;
        int y = heart[1] - 1;

        while (x < N - 1 && y < N - 1 && x > 0 && y > 0 && graph[x][y + 1] == '*') {
            y++;
            rightArm++;
        }
        return rightArm;
    }

    private static int findWaist(int[] heart, char[][] graph) {
        int waist = 0;
        int x = heart[0] - 1;
        int y = heart[1] - 1;

        while (x < N - 1 && y < N - 1 && x > 0 && y > 0 && graph[x + 1][y] == '*') {
            x++;
            waist++;
        }
        return waist;
    }

    private static int findLeftLeg(int[] heart, char[][] graph, int waist) {

        int leftLeg = 0;
        int x = heart[0] - 1 + waist;
        int y = heart[1] - 1;

        while (x < N - 1 && y < N - 1 && x > 0 && y > 0 && graph[x + 1][y - 1] == '*') {
            x++;
            leftLeg++;
        }
        return leftLeg;
    }

    private static int findRightLeg(int[] heart, char[][] graph, int waist) {

        int rightLeg = 0;
        int x = heart[0] - 1 + waist;
        int y = heart[1] - 1;

        while (x < N - 1 && y < N - 1 && x > 0 && y > 0 && graph[x + 1][y + 1] == '*') {
            x++;
            rightLeg++;
        }
        return rightLeg;
    }

}
