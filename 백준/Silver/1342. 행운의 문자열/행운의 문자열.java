import java.io.*;
import java.util.*;

class Main {

    static int[] alphabet = new int[26];
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        N = s.length();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            alphabet[c - 'a']++;
        }
        
        dfs(0, -1);
        System.out.println(cnt);
    }

    public static void dfs(int length, int lastIdx) {
        // 종료 조건
        if (N == length) {
            cnt++;
            return;
        }

        for (int i=0; i < alphabet.length; i++) {
            if (alphabet[i] < 1 || lastIdx == i) {
                continue;
            }
            alphabet[i] --;
            dfs(length + 1, i);
            alphabet[i] ++;
        }
    }
}
// a-z까지 map에다가 전부 기록 
// for (int i=a, i<z; i++) 으로 반복문을 돌림
// a 시작부터 backtracking 시작. -> 근데 이제 current가 다른것만 넣도록.