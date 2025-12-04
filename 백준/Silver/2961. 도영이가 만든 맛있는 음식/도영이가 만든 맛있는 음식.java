// depth를 동적으로 바꾸면서 완탐을 진행하면 될듯?
// 0~N까지 반복문 돌면서 depth 바꾸고, 이걸 백트래킹 하기

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<int[]> food = new ArrayList<>();
    static int[][] arr;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lemon = Integer.parseInt(st.nextToken());
            int drug = Integer.parseInt(st.nextToken());
            food.add(new int[]{lemon, drug});
        }

        for (int i=1; i<=N; i++) {
            arr = new int[i][];
            backtracking(0, i, 0);
        }
        System.out.println(minValue);
    }

    public static void backtracking(int depth, int size, int start) {
        if (depth == size) {
            int cal1 = 1;
            int cal2 = 0;
            for (int i=0; i<arr.length; i++) {
                int[] current = arr[i];
                cal1 *= current[0];
                cal2 += current[1];
            }
            minValue = Math.min(minValue, Math.abs(cal1 - cal2));
            return;
        }

        for (int i=start; i<food.size(); i++) {
            arr[depth] = food.get(i);
            backtracking(depth + 1, size, i + 1);
        }
    }
}