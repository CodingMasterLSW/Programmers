import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for (int a = 0; a < cnt; a++) {
            String word = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열의 크기
            String s = br.readLine(); // 배열 입력
            
            // 빈 배열 처리
            Deque<Integer> deq = new ArrayDeque<>();
            if (n > 0) {  // n이 0인 경우에는 빈 배열
                String[] arr = s.substring(1, s.length() - 1).split(",");
                for (String c : arr) {
                    deq.offer(Integer.parseInt(c));  // 숫자들을 덱에 넣기
                }
            }
            
            char[] array = word.toCharArray();
            boolean reverse = false;
            boolean isError = false;

            for (char c : array) {
                if (c == 'R') {
                    reverse = !reverse;  // 뒤집기 상태 토글
                } else if (c == 'D') {
                    if (deq.isEmpty()) {
                        isError = true; // 덱이 비어있으면 에러
                        break;
                    }
                    if (reverse) {
                        deq.pollLast();  // 뒤집힌 상태에서는 뒤에서 삭제
                    } else {
                        deq.pollFirst(); // 정상 상태에서는 앞에서 삭제
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (reverse) {
                    while (!deq.isEmpty()) {
                        sb.append(deq.pollLast());
                        if (!deq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deq.isEmpty()) {
                        sb.append(deq.pollFirst());
                        if (!deq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}