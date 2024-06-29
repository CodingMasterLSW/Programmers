import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Character[]> words = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String input = sc.next();
            Character[] word = new Character[input.length()];
            for (int j = 0; j < input.length(); j++) {
                word[j] = input.charAt(j);
            }
            words.add(word);
        }

        int maxSize = 0;
        for(int i=0; i<5; i++){
            Character[] characters = words.get(i);
            if(maxSize<characters.length){
                maxSize = characters.length;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<maxSize; i++){

            for(int j=0; j<5; j++) {
                if(words.get(j).length-1<i){
                    continue;
                }

                sb.append(words.get(j)[i]);
            }
        }
        System.out.print(sb.toString());
    }
}
