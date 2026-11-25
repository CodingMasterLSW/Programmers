class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int a = 0; a < targets.length; a++) {
            int sum = 0;
            for (int b = 0; b < targets[a].length(); b++) {
                char t = targets[a].charAt(b);
                int value = findLocation(keymap, t);
                if (value == -1) {
                    sum = -1;
                    break;
                }
                sum += value;
            }
            answer[a] = sum;
        }

        return answer;
    }
    
    public int findLocation(String[] keymap, char t) {
        int idx = 0;
        while(idx < 100) {       
            for (int i=0; i<keymap.length; i++) {
                if (keymap[i].length() <= idx) {
                    continue;
                }
                if (keymap[i].charAt(idx) == t) {
                    return idx+1;
                }
            }
            idx++;
        }
        return -1;
        
    }
}

// 완탐? 
// keymap의 길이 100
// target 길이 100 ^ 2 = 10000 OK 
