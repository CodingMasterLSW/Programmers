import java.util.*;

public class Main {
    static List<int[]> lists = new ArrayList<>();
    static int N;
    static int maxBenefit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            lists.add(new int[]{a1, a2});
        }
        sc.close();

        backtracking(0, 0);
        System.out.println(maxBenefit);
    }

    public static void backtracking(int currentDay, int currentBenefit) {
        if (currentDay >= N) {
            if (currentBenefit > maxBenefit) {
                maxBenefit = currentBenefit;
            }
            return;
        }

        // 현재 날짜의 상담을 선택하는 경우
        if (currentDay + lists.get(currentDay)[0] <= N) {
            backtracking(currentDay + lists.get(currentDay)[0], currentBenefit + lists.get(currentDay)[1]);
        }

        // 현재 날짜의 상담을 선택하지 않는 경우
        backtracking(currentDay + 1, currentBenefit);
    }
}