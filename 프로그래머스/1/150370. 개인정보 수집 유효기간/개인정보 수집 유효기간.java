import java.util.*;

class Solution {
    
    static Map<String, Integer> rules = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            rules.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }
        
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (String privacy : privacies) {
            String[] splitPrivacy = privacy.split(" ");
            String date = splitPrivacy[0];
            String rule = splitPrivacy[1];
            
            String[] splitDate = date.split("\\.");
            int year = Integer.parseInt(splitDate[0]);
            int month = Integer.parseInt(splitDate[1]);
            int day = Integer.parseInt(splitDate[2]);           
            
            // System.out.println("기존 year = " + year);
            // System.out.println("기존 month = " + month);
            // System.out.println("기존 day = " + day);
            int monthPeriod = rules.get(rule);
            int dueMonth = month + monthPeriod;
            
            // System.out.println("monthPeriod = " + monthPeriod);
            month += monthPeriod;
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            
            if (day == 1) {
                month -=1;
                day = 28;
                if (month == 0) {
                    year -= 1;
                    month = 12;
                }
            } else {
                day --;
            }
        
            // System.out.println(year);
            // System.out.println(month);
            // System.out.println(day);
            // System.out.println();
            
            String[] todaySplit = today.split("\\.");
            int todayYear = Integer.parseInt(todaySplit[0]);
            int todayMonth = Integer.parseInt(todaySplit[1]);
            int todayDay = Integer.parseInt(todaySplit[2]);
            
            int sum = (year * 10000 + month * 100 + day * 1);
            int todaySum = (todayYear * 10000 + todayMonth * 100 + todayDay * 1);
            
            if (sum < todaySum) {
                result.add(cnt+1);
            }
            cnt++;
        }
        System.out.println(result);
        int[] realResult = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            realResult[i] = result.get(i);
        }
        return realResult;
    }
}