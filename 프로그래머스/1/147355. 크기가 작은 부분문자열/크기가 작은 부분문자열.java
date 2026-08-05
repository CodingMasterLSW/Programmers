// 슬라이딩 윈도우로 접근
class Solution {
    public int solution(String t, String p) {
        int startIdx = 0;
        int endIdx = startIdx + p.length();

        int cnt = 0;
        while(endIdx <= t.length()) {
            String s = t.substring(startIdx, endIdx);
            //System.out.println("s = " + s);
            if (Long.parseLong(s) <= Long.parseLong(p)) {
                cnt++;
            }
            startIdx++;
            endIdx++;
        }
        return cnt;
    }
}