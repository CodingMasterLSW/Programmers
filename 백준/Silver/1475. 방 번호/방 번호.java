import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Map<Character, Integer> maps = new HashMap<>();

        for(char c : s.toCharArray()){
            if(c=='9' || c=='6'){
                maps.put('6', maps.getOrDefault('6', 0) +1);
            } else{
                maps.put(c, maps.getOrDefault(c, 0)+1);

            }
        }

        int max = 0;
        for(Map.Entry<Character, Integer> entry : maps.entrySet()){
            if(entry.getKey()=='6'){
                if(max<entry.getValue()){
                    max = (int) Math.ceil(entry.getValue()/2.0);
                }
            } else {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                }
            }
        }
        System.out.println(max);
    }

}
