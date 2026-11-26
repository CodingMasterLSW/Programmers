// 단어가 주어졌을 때, 몇 번째 단어인지를 파악해야 함.
// 중복 가능

class Solution {
    
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static int cnt = -1;
    
    public int solution(String word) {
        dfs(word, "", 0);
        return cnt;
    }
    
    public boolean dfs(String word, String current, int length) {
        cnt++;
        if (current.equals(word)) {
            return true;
        }
        // 종료 조건 : 길이가 5 이상
        if (length == 5) {
            // 종료 시 행동
            return false;
        }
        
        for (char c : arr) {
            if (dfs(word, current + c, length + 1)) {
                return true;
            }
        }
        return false;
        
    }
    
    
}
