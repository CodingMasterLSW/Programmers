import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<String> lists = new ArrayList<>(words.keySet());

        lists.sort((a,b) -> {
            int c1 = words.get(a);
            int c2 = words.get(b);

            if(c1==c2){
                if(b.length() == a.length()){
                    return a.compareTo(b);
                }
                return b.length() - a.length(); // 길이순 배열
            }
            return c2-c1; //횟수 순 배열

        });

        for(String l : lists){
            bw.write(String.valueOf(l));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
