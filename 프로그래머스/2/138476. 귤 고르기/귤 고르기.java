import java.util.*;
class Solution {
    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int key : tangerine) {
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }
        List<Integer> lists = new ArrayList<>();
        for(int value : result.values()){
            lists.add(value);
        }

        Collections.sort(lists, Collections.reverseOrder());
        int sum = 0;
        int cnt = 0;
        for(int l : lists){
            sum += l;
            cnt++;
            if(sum>=k){
                break;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}