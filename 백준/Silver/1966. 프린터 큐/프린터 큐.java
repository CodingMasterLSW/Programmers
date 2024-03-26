
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();

            for (int j = 0; j < x; j++) {
                q.offer(new int[]{Integer.parseInt(st.nextToken()), j});
            }

            int cnt = 0;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                boolean isMax = true;
                for (int[] doc : q) {
                    if (doc[0] > current[0]) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    cnt++;
                    if (current[1] == y) {
                        System.out.println(cnt);
                        break;
                    }
                } else{
                    q.offer(current);
            }
        }
    }
}
}
