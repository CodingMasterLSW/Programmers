import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int ax = 0;
        int bx = 0;
        int cx = 0;
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == a[i % 5]) {
                ax++;
            } 
            if (answers[i] == b[i % 8]) {
                bx++;
            }
            if (answers[i] == c[i % 10]) {
                cx ++;
            }
        }
        
        int max = Math.max(Math.max(ax, bx), cx);
        
        int[] tmp = new int[]{ax, bx, cx};
        List<Integer> arr = new ArrayList<>();
        
        for (int i=0; i<3; i++) {
            if (tmp[i] == max) {
                arr.add(i+1);
            }
        }
        
        int[] answer = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
       
        return answer;
    }
}