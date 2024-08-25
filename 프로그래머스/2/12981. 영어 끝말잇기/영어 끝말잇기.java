import java.util.*; 

class Solution {
    
    static Map<String, Integer> maps = new HashMap<>();

    public int[] solution(int n, String[] words) {
        String firstWord = words[0];

        // 마지막 알파벳
        char currentChar = firstWord.charAt(firstWord.length() - 1);

        maps.put(words[0], 0);

        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            boolean duplicate = isDuplicate(currentWord);
            boolean gameResult = playGame(currentWord, currentChar);

            if (duplicate && gameResult) {
                maps.put(currentWord, 0);
                currentChar = currentWord.charAt(currentWord.length() - 1);
            } else {
                int[] res = new int[2];
                if ((i+1) % n == 0) {
                    System.out.println("i = " + i);
                    System.out.println("n = " + n);
                    System.out.println("res[0] = " + res[0]);
                    res[0] = n;
                } else {
                    res[0] = (i+1) % n;
                    System.out.println("i = " + i);
                    System.out.println("n = " + n);
                    System.out.println("res[0] =" + res[0]);
                }
                res[1] = (int) Math.ceil((double)(i + 1) / n);
                System.out.println("i = " + i);
                System.out.println("n = " + n);
                System.out.println("res[1] = " + res[1]);
                return res;
            }
        }
        int[] res = {0,0};
        return res;

    }

    public static boolean isDuplicate(String word) {
        if (maps.containsKey(word)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean playGame(String word, char currentChar) {
        if (word.charAt(0) == currentChar) {
            return true;
        } else {
            return false;
        }
    }

}
