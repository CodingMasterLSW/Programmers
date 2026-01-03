import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> arrs = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        
        // 초기화 
        for (String id : id_list) {
            arrs.put(id, new HashSet<>());
            reportCount.put(id, 0);
        }
        
        // report 계산
        int idx = 0;
        for (String s : report) {
            String[] split = s.split(" ");
            String name = split[0];
            String target = split[1];
            
            Set<String> reportHistories = arrs.get(name);
            if (reportHistories.add(target)) {
                reportCount.put(target, reportCount.get(target) + 1);
            }
            
        }
        
        // 메일 발송 목록 추리기
        
        int[] answer = new int[arrs.size()];
 
        for (int i=0; i<arrs.size(); i++) {
            int cnt = 0;
            
            Set<String> reportHistories = arrs.get(id_list[i]);
            
            for (String history : reportHistories) {
                if (reportCount.get(history) >= k) {
                    cnt++;
                } 
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}