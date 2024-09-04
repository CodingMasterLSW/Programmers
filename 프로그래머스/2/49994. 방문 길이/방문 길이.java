import java.util.*;

class Solution {
    
    static int x;
    static int y;
    static int cnt;
    static Set<String> sets = new HashSet<>();
    
    public int solution(String dirs) {
        for(int i = 0; i < dirs.length(); i++){
            if(dirs.charAt(i) == 'U'){
                move(x, y, x, y + 1);  // 위로 이동
            } else if(dirs.charAt(i) == 'D'){
                move(x, y, x, y - 1);  // 아래로 이동
            } else if(dirs.charAt(i) == 'L'){
                move(x, y, x - 1, y);  // 왼쪽으로 이동
            } else if(dirs.charAt(i) == 'R'){
                move(x, y, x + 1, y);  // 오른쪽으로 이동
            }
        }
        return cnt;
    }
    public static void move(int fromX, int fromY, int toX, int toY){
        
        if (toX > 5 || toX < -5 || toY > 5 || toY < -5) {
            return;
        }
        
        String path1 = fromX + "," + fromY + "->" + toX + "," + toY;
        String path2 = toX + "," + toY + "->" + fromX + "," + fromY;
        
        if (!sets.contains(path1) && !sets.contains(path2)) {
            sets.add(path1);
            sets.add(path2);
            cnt++;  // 새로운 경로일 때만 카운트 증가
        }
        
        x = toX;
        y = toY;
        
    }
}