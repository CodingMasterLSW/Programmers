// 선물 지수 = 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
// 값이 같을 경우에는, 선물 지수가 더 큰 사람 <- 선물 지수가 더 작은 사람
// 선물 지수도 같다면, 패스
// 다음달에 가장 많은 선물을 받는 사람의 선물의 개수 return하기
// 문자열 분리 시, s[0] = 선물 준 사람, s[1] = 선물 받은 사람

// Person이라는 객체를 하나 만들기
// key = muzi 
// value = {-gives -receives}

// 저거 반복문 돌 때, muzi.gives -> ryan이랑 비교.

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, GiftHistory> histories = new HashMap<>();
        
        for (String friend : friends) {
            histories.put(friend, new GiftHistory());
        }
        
        for (String gift : gifts) {
            String[] s = gift.split(" ");
            String giver = s[0];
            String receiver = s[1];
            
            GiftHistory giftHistory = histories.get(giver);
            giftHistory.gives.add(receiver);
            
            GiftHistory giftHistory2 = histories.get(receiver);
            giftHistory2.receives.add(giver);
        } 
        
        int maxResult = 0;
        for (String s : histories.keySet()) {
            // 무지 차례
            GiftHistory giftHistory = histories.get(s);
            int result = 0;
            // 여기서 계산해야함
            for (String friend : friends) {
                if (s == friend) {
                    continue;
                }
                GiftHistory friendGiftHistory = histories.get(friend);
                int value1 = giftHistory.calReceiveCount(friend); // 무지가 라이언에게 몇 개 받았니
                int value2 = friendGiftHistory.calReceiveCount(s); // 라이언이 무지에게 몇 개 받았니
                if (value1 < value2) {
                    result++;
                }
                
                if (value1 == value2) {
                    int v = giftHistory.calGiftValue();
                    int k = friendGiftHistory.calGiftValue();
                    if (v > k) {
                        result ++;
                    }
                }
            }
            maxResult = Math.max(result, maxResult);
        }
        return maxResult;
    }
}

class GiftHistory {
    public List<String> gives = new ArrayList<>();
    public List<String> receives = new ArrayList<>();
    
    public int calGiftValue() {
        return gives.size() - receives.size();
    }
    
    public int calReceiveCount(String target) {
        int count = 0;
        for (String receive : receives) {
            if (receive.equals(target)) {
                count++;
            }
        }
        return count;
    }
    
    
}