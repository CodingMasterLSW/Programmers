import java.util.*;
class Solution {
    public static int[] solution(int[] answers) {
    
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {2,1,2,3,2,4,2,5};
        int[] array3 = {3,3,1,1,2,2,4,4,5,5};

        int score1 = cal1(array1, answers);
        int score2 = cal1(array2, answers);
        int score3 = cal1(array3, answers);
        
        int[] scores = {score1, score2, score3};
        
        int max = scores[0];
        for(int score : scores){
            if(score>max){
                max = score;
            }
        }
        
        List<Integer> lists = new ArrayList<>();
        
        for(int i=0; i<scores.length; i++){
            if(scores[i] == max){
                lists.add(i+1);
            }
        }
        Collections.sort(lists);
        
        int[] result = new int[lists.size()];
        
        for(int i=0; i<lists.size(); i++){
            result[i] = lists.get(i);
        }
        
        return result;
    
    }

    static int cal1(int[] array1, int[] answers){
        int result = 0;
        for(int i=0; i<answers.length; i++){

            int idx = (i%array1.length)+1;

            if(array1[idx-1] == answers[i]){
                result++;
            }
        }
        return result;
    }

}