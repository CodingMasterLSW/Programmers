import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    //     System.out.println("map.put : " + n);
                } else if (s.equals("D")) {
                    if (n < 0) {
                        if (map.isEmpty()) {
                            continue;
                        }
                        //        System.out.println("map 최솟값 삭제: " + map.firstKey());
                        if (map.get(map.firstKey()) > 1) {
                            map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                        } else {
                            map.remove(map.firstKey());
                        }
                    } else {
                        if (map.isEmpty()) {
                            continue;
                        }
                        //     System.out.println("map 최댓값 삭졔:" + map.lastKey());
                        if (map.get(map.lastKey()) > 1) {
                            map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                        } else {
                            map.remove(map.lastKey());
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }

}
