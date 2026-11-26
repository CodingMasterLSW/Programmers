import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Set<Integer> result = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        backtracking(numbers, "");
        
        int cnt = 0;
        for (int r : result) {
            if (isDecimal(r)) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public void backtracking(String numbers, String current) {
        if (!current.isEmpty()) {
            result.add(Integer.parseInt(current));
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(numbers, current + numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    public boolean isDecimal(int target) {
        if (target < 2) {
            return false;
        }
        
        for (int i=2; i*i <= target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}




// 일단 가능한 모든 숫자들을 만들고 (Backtracking)
// 그 수가 소수인지 판별을 한다. (계속 나눗셈 하기)