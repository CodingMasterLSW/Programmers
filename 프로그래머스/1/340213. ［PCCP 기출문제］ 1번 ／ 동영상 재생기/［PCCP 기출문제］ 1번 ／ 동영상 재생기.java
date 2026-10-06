class Solution {
    public String solution(
        String video_len,
        String pos,
        String op_start,
        String op_end,
        String[] commands
    ) 
    {
        String currentTime = pos;
        
        for (String command : commands) {
            if (command.equals("prev")) {
                String newTime = prev(currentTime, video_len, op_start, op_end);
                currentTime = newTime;
            }
            if (command.equals("next")) {
                String newTime = next(currentTime, video_len, op_start, op_end);
                currentTime = newTime;
            }

        }
        StringBuilder sb = new StringBuilder();
        
        String[] split = currentTime.split(":");
        int min = Integer.parseInt(split[0]);
        sb.append(min / 10).append(min % 10).append(":");
        
        int sec = Integer.parseInt(split[1]);
        sb.append(sec / 10).append(sec % 10);
        return sb.toString();
    }
    
    public String prev(String pos, String video_len, String op_start, String op_end) {
        String value = op(pos, op_start, op_end);
        int sec = changeSec(value);
        int prevSec = Math.max(sec - 10, 0);
        
        String value2 = merge(prevSec);
        return op(value2, op_start, op_end);
    }
    
    public String next(String pos, String video_len, String op_start, String op_end) {
        
        String value = op(pos, op_start, op_end);
        
        int sec = changeSec(value);
        int video_sec = changeSec(video_len);
        
        int afterSec = Math.min(sec + 10, video_sec);
        
        String value2 = merge(afterSec);
        return op(value2, op_start, op_end);
    }
    
    public String op(String pos, String op_start, String op_end) {
        int posSec = changeSec(pos);
        
        int op_start_sec = changeSec(op_start);
        int op_end_sec = changeSec(op_end);
        
        if (op_start_sec <= posSec && posSec <= op_end_sec) {
            return merge(op_end_sec);
        }
        return merge(posSec);
    }
    
    public int changeSec(String time) {
        String[] split = time.split(":");
        String min = split[0];
        String sec = split[1]; 
        return (Integer.parseInt(min) * 60) + Integer.parseInt(sec);
    }
    
    public String merge(int sec) {
        int newMin = sec / 60;
        int newSec = sec % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(newMin).append(":").append(newSec);
        return sb.toString();
    }
    
}