// 중복 닉네임 허용 가능 
// Map을 사용해야 할 듯. {key = uid, value = nickname}
// 객체를 만들어서 Queue에 넣고 결과를 출력한다? 나이스

// 1. record를 파싱
// 2. Enter, Change 메서드를 구현한다.
// 3. Queue에 담는다.

import java.util.*;

class Solution {
    
    static Map<String, String> users = new HashMap<>();
    static Queue<String[]> q = new ArrayDeque<>();
    
    public String[] solution(String[] record) {
        for (String r : record) {
            String[] splitResult = r.split(" ");
            String method = splitResult[0];
            String uid = splitResult[1];
            
            if (method.equals("Leave")) {
                q.offer(new String[]{method, uid});
                continue;
            }
    
            String name = splitResult[2];
            users.put(uid, name);
            
            if (method.equals("Enter")) {
                q.offer(new String[]{method, uid});
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()) {
            String[] current = q.poll();
            String method = current[0];
            String uid = current[1];
            if (method.equals("Enter")) {
                sb.append(users.get(uid)+"님이 들어왔습니다." + "  ");
            }
            if (method.equals("Leave")) {
                sb.append(users.get(uid)+"님이 나갔습니다." + "  ");
            }
        }
        return sb.toString().split("  ");
    }
    
  
}
