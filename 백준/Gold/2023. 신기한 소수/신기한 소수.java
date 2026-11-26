import java.io.*;
import java.util.*;

// backtracking 하는데 중복 가능
// -> 굳이 boolean 배열이 필요 없다.
// 생각해야 할 부분: 탐색 자릿수가 소수가 아니면, 그 뒤를 탐색할 필요가 없음.

class Main {

    static int depth;
    static StringBuilder sb = new StringBuilder();
    static int[] startPoint = {2, 3, 5, 7};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        depth = input;
        for (int s : startPoint) {
            dfs(s, 1);
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int num, int len) {
        if(!isDecimal(num)) {
            return;
        }
        // 종료조건
        // 1) 4자릿수가 되었을 때 판별 + 답안에 넣기
        if (depth == len) {
            if (isDecimal(num)) {
                sb.append(num).append("\n");
            }
            return;
        }

        for (int i=0; i<10; i++) {
            dfs(num * 10 + i, len+1);
        }
    }

    public static boolean isDecimal(int target) {
        if (target < 2) {
            return false;
        }

        for (int i=2; i*i <= target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}