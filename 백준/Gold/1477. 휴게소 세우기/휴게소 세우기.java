
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N + 2];
        arr[0] = 0;  // 시작점
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        arr[N + 1] = L;  // 끝점

        Arrays.sort(arr);

        int start = 1;
        int end = L - 1;

        // 이분 탐색: 최소 최대 간격 찾기
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (check(arr, mid)) { // mid 가능 → 더 작은 값 시도
                end = mid;
            } else {               // mid 불가능 → 더 큰 값 시도
                start = mid;
            }
        }

        // 종료 후 start와 end 중 최소값 결정
        int ans = check(arr, start) ? start : end;
        System.out.println(ans);
    }

    // mid 간격으로 휴게소를 추가할 때 M개 이하로 가능한지 확인
    private static boolean check(int[] arr, int mid) {
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            cnt += (gap - 1) / mid;  // 추가 휴게소 개수
        }
        return cnt <= M;
    }
}
