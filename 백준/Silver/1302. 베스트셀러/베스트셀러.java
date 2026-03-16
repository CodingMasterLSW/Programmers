import java.io.*;
import java.util.*;

class Main {

    static Map<String, Integer> maps = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            maps.put(s, maps.getOrDefault(s, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        int maxResult = 0;
        for (String m : maps.keySet()) {
            if (maps.get(m) > maxResult) {
                result.clear();
                maxResult = maps.get(m);
                result.add(m);
            } else if (maps.get(m) == maxResult) {
                result.add(m);
            }
        }
        Collections.sort(result, (a,b) -> a.compareTo(b));
    
        System.out.println(result.get(0));
    }
}