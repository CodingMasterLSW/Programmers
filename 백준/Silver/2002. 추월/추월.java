import java.io.*;
import java.util.*;

class Main {

    static int N;
    static Map<String, Integer> maps = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<String> q2 = new ArrayDeque<>();

        for (int i=0; i < N; i++) {
            maps.put(br.readLine(), i+1);
        }

        for (int i=0; i < N; i++) {
            q2.offer(br.readLine());
        }

        int cnt = 0;
        int currentIdx = 1;
        while (!q2.isEmpty()) {
            String value = q2.poll();
            // System.out.println("value = " + value);
            int current = maps.get(value);
            // System.out.println("current = " + current);
            // System.out.println("currentIdx = " + currentIdx);

            if (currentIdx < current) {
                cnt++;
                // System.out.println("cnt++, cnt = " + cnt);
                update(current);
            } else {
                currentIdx++;
                // System.out.println("currentIdx ++, currentIdx = " + currentIdx);
            }
            // System.out.println();

        }
        System.out.println(cnt);
    }

    public static void update(int targetIdx) {
        for (String key : maps.keySet()) {
            if (maps.get(key) < targetIdx) {
                continue;
            }

            if (maps.get(key) == targetIdx) {
                maps.put(key, -1);
                continue;
            }

            if (maps.get(key) > targetIdx) {
                maps.put(key, maps.get(key) - 1);
            }
        }
        // System.out.println("update Map");
        // System.out.println(maps);
    }
}