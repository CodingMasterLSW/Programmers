import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 나무의 개수
        int M = Integer.parseInt(st.nextToken());  // 가져가야 할 나무의 길이

        List<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int maxTree = 0;
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            maxTree = Math.max(tree, maxTree);  // 가장 큰 나무의 높이를 찾음
            trees.add(tree);
        }

        // 이분 탐색 시작
        while (start <= maxTree) {  // <= 조건으로 마지막 범위까지 확인
            long sum = 0;  // 나무 높이의 합을 long으로 선언
            int currentTree = (start + maxTree) / 2;

            // 잘린 나무의 길이 합산
            for (int tree : trees) {
                if (tree > currentTree) {
                    sum += (tree - currentTree);  // 잘린 부분만 더함
                }
            }

            if (sum < M) {
                maxTree = currentTree - 1;  // 나무가 부족하면 높이를 낮춤
            } else {
                start = currentTree + 1;  // 나무가 충분하면 높이를 높임
            }
        }

        // 최적의 절단 높이 출력
        System.out.println(maxTree);
    }
}