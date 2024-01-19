import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        int[][] rooms = new int[k][2];
        for (int i = 0; i < k; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            rooms[i][0] = Integer.parseInt(st1.nextToken());
            rooms[i][1] = Integer.parseInt(st1.nextToken());

        }
        // room[0] 기준으로 오름차순 정렬
        // room[0] 이 같다면, room[1] 기준으로 오름차순 정렬

        Arrays.sort(rooms, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }

        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] room : rooms) {
            // 만약 현재 강의실의 끝나는 시간보다 새 수업의 시작 시간이 늦다면
            if (!pq.isEmpty() && pq.peek() <= room[0]) {
                pq.poll();
            }
            // 새 수업의 끝나는 시간을 힙에 추가
            pq.offer(room[1]);
        }

        br.close();
        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();



    }


}
