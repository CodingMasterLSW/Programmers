// 토, 일의 출근 시각은 이벤트에 영향x
// startday를 기준으로 토/일을 판단해야함

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        
        for (int i=0; i<schedules.length; i++) {
            //System.out.println(i+1 + "번 직원 시작 ");            
            int targetSchedule = toMinutes(schedules[i]) + 10;
            
            int[] targetLog = timelogs[i];
            
            int cnt = 0;
            int newDay = startday - 1;
            boolean status = true;
            
            for (int j=0; j<targetLog.length; j++) {
                int targetDay = (cnt + newDay) % 7;
                if (targetDay == 5 || targetDay == 6) {
                    cnt++;
                    //System.out.println("주말은 패스");
                    continue;
                }
                if (toMinutes(targetLog[j]) > targetSchedule ) {
                    status = false;
                    //System.out.println("지각 시간 : = " + targetLog[j]);
                    //System.out.println("출근시간 : = " + targetSchedule);
                    //System.out.println("지각");
                } else {
                    //System.out.println("정상 출근");
                }
                cnt++;
            }
            if (status) {
                result++;
            }
        }
        return result;
    }
    
    private int toMinutes(int t) {
        return (t / 100) * 60 + (t % 100);
    }
}