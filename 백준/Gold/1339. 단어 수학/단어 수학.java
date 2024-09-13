import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> lists = new ArrayList<>();
        Map<Character, Integer> wordWeight = new HashMap<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            lists.add(s);
            int len = s.length();

            for(int j=0; j<len; j++){
                char c = s.charAt(j);
                int weight = (int) Math.pow(10,len-j);
                wordWeight.put(c, wordWeight.getOrDefault(c, 0)+ weight);
            }

        }

        List<Character> tmpList = new ArrayList<>(wordWeight.keySet());
        Collections.sort(tmpList, (a1, a2) ->
                wordWeight.get(a2)-wordWeight.get(a1));


        Map<Character, Integer> resMap = new HashMap<>();

        int startResult = 9;
        for (Character c : tmpList) {
            resMap.put(c, startResult);
            startResult --;
        }

        List<Integer> tmpIntegerRes = new ArrayList<>();
        for(String list : lists){
            StringBuilder sb = new StringBuilder();
            char[] tmpCh = list.toCharArray();

            for(int i=0; i<tmpCh.length; i++){
                Integer integer = resMap.get(tmpCh[i]);
                sb.append(String.valueOf(integer));
            }
            tmpIntegerRes.add(Integer.valueOf(sb.toString()));
        }
        int sum = 0;

        for (Integer tmpIntegerRe : tmpIntegerRes) {
            sum+=tmpIntegerRe;
        }
        System.out.println(sum);


    }

}
