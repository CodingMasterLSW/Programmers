import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<String> wheels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            String st1 = br.readLine();
            wheels.add(st1);
        }

        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int selectWheel = Integer.parseInt(st2.nextToken());
            int selectDirection = Integer.parseInt(st2.nextToken());

            // 회전 실행
            rotateWheels(selectWheel, selectDirection);
        }

        // 점수 계산
        int score = calculateScore();
        bw.write(String.valueOf(score));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }

    // 톱니바퀴 회전 여부를 결정하고 회전시키는 함수
    private static void rotateWheels(int selectWheel, int selectDirection) {
        boolean[] visited = new boolean[4]; // 방문 여부 확인
        rotate(selectWheel - 1, selectDirection, visited);
    }

    private static void rotate(int wheelIndex, int direction, boolean[] visited) {
        visited[wheelIndex] = true; // 현재 휠 방문 처리

        int left = wheelIndex - 1;
        int right = wheelIndex + 1;

        // 왼쪽 휠 확인 및 회전
        if (left >= 0 && !visited[left] && wheels.get(left).charAt(2) != wheels.get(wheelIndex).charAt(6)) {
            rotate(left, -direction, visited); // 반대 방향으로 회전
        }

        // 오른쪽 휠 확인 및 회전
        if (right < 4 && !visited[right] && wheels.get(right).charAt(6) != wheels.get(wheelIndex).charAt(2)) {
            rotate(right, -direction, visited); // 반대 방향으로 회전
        }

        // 현재 휠 회전
        if (direction == 1) {
            wheels.set(wheelIndex, rotateClockwise(wheels.get(wheelIndex)));
        } else {
            wheels.set(wheelIndex, rotateCounterClockwise(wheels.get(wheelIndex)));
        }
    }

    // 시계방향 회전
    private static String rotateClockwise(String wheel) {
        return wheel.charAt(wheel.length() - 1) + wheel.substring(0, wheel.length() - 1);
    }

    // 반시계방향 회전
    private static String rotateCounterClockwise(String wheel) {
        return wheel.substring(1) + wheel.charAt(0);
    }

    // 점수 계산
    private static int calculateScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels.get(i).charAt(0) == '1') {
                score += Math.pow(2, i);
            }
        }
        return score;
    }
}