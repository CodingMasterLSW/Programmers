import java.util.*;

class Solution {
    public static int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);

        int start = 0;
        for(int i = people.length-1; i>=start; i--){
            if(people[start]+people[i]<=limit){
                start++;
            }
            cnt++;
        }

        return cnt;
    }
}