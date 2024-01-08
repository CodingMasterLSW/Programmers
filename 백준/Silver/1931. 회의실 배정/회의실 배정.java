import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[][] time = new int[count][2];
        for (int i = 0; i < count; i++) {
            time[i][0] = sc.nextInt(); // 시작 시간
            time[i][1] = sc.nextInt(); // 종료 시간
        }
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 이 경우엔 시작시간이 빠른걸 해야겠지
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];

            }

        });
        int prev_end_time = 0;
        int cnt = 0;

        for (int i = 0; i < count; i++) {
            if (prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}