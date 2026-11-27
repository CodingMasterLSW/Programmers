import java.io.*;
import java.util.*;

// 순서는 신경X -> IX -> 9인데 여기선 그냥 11 
// N개를 사용해서 만들 수 있는 서로 다른 수의 개수
// 중복이 허용되겠지.

class Main {

    static Set<Integer> history = new HashSet<>();
    static char[] arr = {'I', 'V', 'X', 'L'};
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, "", 0);
        System.out.println(cnt);
    }
    
    public static void dfs(int start, String current, int count) {
        if (N == count) {
            int value = convert(current);
            if (history.add(value)) {
                cnt++;
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            dfs(i, current + arr[i], count + 1);
        }
    }

    public static int convert(String current) {
        int amount = 0;
        for (int i=0; i<current.length(); i++) {
            char c = current.charAt(i);
            if (c == 'I') {
                amount +=1;
            } else if (c == 'V') {
                amount += 5;
            } else if (c == 'X') {
                amount += 10;
            } else if (c == 'L') {
                amount += 50;
            }
        }
        return amount;
    }
}