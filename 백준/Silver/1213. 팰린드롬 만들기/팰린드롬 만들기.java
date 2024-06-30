import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> maps = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }

        int onlyOneOdd = 0;
        List<Character> lists = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
            lists.add(entry.getKey());

            if (entry.getValue() % 2 != 0) {
                onlyOneOdd++;
            }
        }
        Collections.sort(lists);
        List<Character> sb1 = new ArrayList<>();
        List<Character> sb2 = new ArrayList<>();
        List<Character> sb3 = new ArrayList<>();

        if (onlyOneOdd > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < lists.size(); i++) {
                int count = maps.get(lists.get(i));
                if (count % 2 != 0) {
                    sb3.add(lists.get(i));
                }
                for (int j = 0; j < count / 2; j++) {
                    sb1.add(lists.get(i));
                }
            }

        }
        StringBuilder sb = new StringBuilder();

        for(int i= sb1.size()-1; i>-1; i--){
            sb2.add(sb1.get(i));
        }

        for(char c : sb1){
            sb.append(c);
        }
        for(char c : sb3){
            sb.append(c);
        }
        for(char c : sb2){
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
