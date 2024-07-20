import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        char[] lists = sc.nextLine().toCharArray();

        int cnt = 0;
        for(int i=0; i<N; i++){
            if (lists[i] == 'P') {
                for(int j= Math.max(0, i-K); j<= Math.min(N-1, i+K); j++){
                    if(lists[j] == 'H'){
                        cnt++;
                        lists[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

}
