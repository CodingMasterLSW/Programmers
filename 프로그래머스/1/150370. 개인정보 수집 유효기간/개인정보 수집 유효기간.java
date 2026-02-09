// Map으로 약관 저장
// privacies 일자로 치환 후 계산하기
// today 일자로 치환 후 계산하기

import java.util.*;

class Solution {
    
    static Map<String, Integer> type = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            type.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            
            String[] splitPrivacy = privacy.split(" ");
            
            String date = splitPrivacy[0];
            String keyType = splitPrivacy[1];
            
            int addValue = type.get(keyType);
            
            String[] splitDate = date.split("\\.");
            
            int year = Integer.parseInt(splitDate[0]);
            int month = Integer.parseInt(splitDate[1]);
            int day = Integer.parseInt(splitDate[2]);
            
            int privacyValue = (year * 28 * 12) + (month * 28) + day + addValue * 28;
            
            
            String[] todaySplit = today.split("\\.");
            int year2 = Integer.parseInt(todaySplit[0]);
            int month2 = Integer.parseInt(todaySplit[1]);
            int day2 = Integer.parseInt(todaySplit[2]);
            
            int todayValue = (year2 * 28 * 12) + (month2 * 28) + day2;
            
      
            if (privacyValue <= todayValue) {
                result.add(i+1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}