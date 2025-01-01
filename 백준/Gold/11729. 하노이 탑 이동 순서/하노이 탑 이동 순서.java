import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void hanoi(int N, int start, int mid, int to) {
        cnt++;
        if (N==1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        hanoi(N-1, start, to, mid);
        sb.append(start + " " + to + "\n");
        hanoi(N-1, mid, start, to);
    }
}
