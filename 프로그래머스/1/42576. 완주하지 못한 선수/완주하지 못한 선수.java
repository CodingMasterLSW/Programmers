import java.util.*;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> maps = new HashMap<>();
        for (String k : participant) {
            maps.put(k, maps.getOrDefault(k, 0) + 1);
        }
        for (String m : completion) {
            maps.put(m, maps.get(m) - 1);
        }

        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }

        }
        return null;
    }
}