import java.util.*;

class Solution {
    
    static List<String> lists = new ArrayList<>();
    static char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int res = 0;
        dfs("");
        
        for(int i=0; i<lists.size(); i++){
            if(lists.get(i).equals(word)){
                res = i;
                break;
            }
        }
        return res;
        
    }
    
    public static void dfs(String result){
        lists.add(result);
        
        if(result.length() == 5){
            return;
        }
        
        for(int i=0; i<vowel.length; i++){
            dfs(result + vowel[i]);
        }
    }
}