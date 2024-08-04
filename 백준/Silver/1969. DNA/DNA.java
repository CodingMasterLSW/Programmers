import java.io.*;
import java.util.*;

public class Main {

    static char[][] graph;
    static List<Character> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> tmp = new ArrayList<>();

        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            tmp.add(s);

            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        for (int j = 0; j < M; j++) {
            Map<Character, Integer> maps = new HashMap<>();
            for (int i = 0; i < N; i++) {
                maps.put(graph[i][j], maps.getOrDefault(graph[i][j], 0) + 1);
            }

            int maxCount = 0;
            char maxChar = 'a';
            for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxChar = entry.getKey();
                } else if (entry.getValue() == maxCount) {
                    if (entry.getKey() < maxChar) {
                        maxChar = entry.getKey();
                    }
                }
            }

            lists.add(maxChar);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : lists){
            sb.append(c);
        }

        String s = sb.toString();

        for(String t : tmp){

            for(int i=0; i<t.length(); i++){
                if(t.charAt(i) != s.charAt(i)){
                    count++;
                }
            }
        }
        System.out.println(s);
        System.out.println(count);

    }

}
