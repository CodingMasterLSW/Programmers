
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> tmpSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int currentIdx = 0;

        for (int i = 1; i <= N; i++) {
            dq.push(i);
            sb.append("+" +"\n");

            while (true) {
                int target = arr.get(currentIdx);
                if (i < target) {
                    break;
                }
                int popResult = dq.pop();
                sb.append("-" + "\n");
                if (popResult == target) {
                    currentIdx ++;
                    tmpSet.add(target);
                }
                if (dq.isEmpty()) {
                    break;
                }
            }
        }

        if (tmpSet.size() == arr.size()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}