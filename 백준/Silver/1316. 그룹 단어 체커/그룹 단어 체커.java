

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int k = sc.nextInt();

        for (int s = 0; s < k; s++) {
            String n = sc.next();

            Map<Character, Integer> maps = new LinkedHashMap<>();
            for (int i = 0; i < n.length(); i++) {
                if (i < n.length() - 1 && n.charAt(i) == n.charAt(i + 1)) {
                    continue;
                }
                maps.put(n.charAt(i), maps.getOrDefault(n.charAt(i), 0) + 1);
            }
            int cnt = 1;
            for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
                if (entry.getValue() != 1) {
                    cnt = 0;
                }
            }

            if (cnt != 0) {
                result++;
            }

        }
        System.out.println(result);
    }

}
