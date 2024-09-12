import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> weightMap = new HashMap<>();
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            wordList.add(word);
            int len = word.length();
            // 가중치 계산 코드
            for (int j = 0; j < len; j++) {
                char ch = word.charAt(j);
                int weight = (int) Math.pow(10, len - j - 1);
                // 기존 값에 더하기
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + weight);
            }
        }

        List<Character> keySet = new ArrayList<>(weightMap.keySet());
        keySet.sort((k1, k2) ->
                weightMap.get(k2).compareTo(weightMap.get(k1)));
        // value 값 높은 순서대로 큰 수 배정

        Map<Character, Integer> resultMap = new HashMap<>();

        int startValue = 9;

        for (char c : keySet) {
            resultMap.put(c, startValue);
            startValue--;
        }
        List<Integer> result = new ArrayList<>();

        for (String word : wordList) {
            StringBuilder sb = new StringBuilder();
            char[] wordC = word.toCharArray();
            for (int i = 0; i < wordC.length; i++) {
                Integer res = resultMap.get(wordC[i]);
                sb.append(String.valueOf(res));
            }
            result.add(Integer.parseInt(sb.toString()));
        }
        int sum = 0;
        for (Integer integer : result) {
            sum += integer;
        }
        System.out.println(sum);
    }

}
