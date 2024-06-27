import java.util.*;

class Solution {
    public static int[] solution(int brown, int yellow) {

        List<int[]> rec = new ArrayList<>();

        for(int i=1; i<=(yellow/2)+1; i++){
            if(yellow%i==0){
                int x = yellow/i;
                int y = i;

                rec.add(new int[]{x,y});
            }
        }

        List<int[]> answer = new ArrayList<>();

        for(int[] result : rec){
            if(((result[0]+2)*2+result[1]*2) == brown){
                answer.add(new int[]{result[0]+2, result[1]+2});
            }
        }

        int[] finalResult = new int[2];
        finalResult[0] = Math.max(answer.get(0)[0], answer.get(0)[1]);
        finalResult[1] = Math.min(answer.get(0)[0], answer.get(0)[1]);
        
        return finalResult;
    }
}