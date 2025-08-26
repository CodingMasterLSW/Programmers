import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int a = sc.nextInt();
        final int b = sc.nextInt();

        boolean[] arr = new boolean[b+1];

        for (int i=2; i<=b; i++) {
            arr[i] = true;
        }

        for (int i=2; i*i <= b; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= b; j += i) {
                    arr[j] = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=a; i<=b; i++) {
            if (arr[i]) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}