import java.util.*;

class Solution {
    
    static Set<Integer> a = new HashSet<>();
    static Set<Integer> b = new HashSet<>();
    
    static int value;
    
    public int solution(int coin, int[] cards) {
        value = cards.length + 1;
        
        for (int i=0; i< cards.length / 3; i++) {
            a.add(cards[i]);
        }
        
        
        int round = 1;
        int currentIdx = cards.length / 3;
        
        int leftCoin = coin;
        while(currentIdx < cards.length) {
            b.add(cards[currentIdx]);
            b.add(cards[currentIdx+1]);
            
            boolean found = false;
            for (int v : a) {
                if (a.contains(value - v) && a.contains(v)) {
                    found = true;
                    a.remove(value - v);
                    a.remove(v);
                    break;
                }
            }
            
            if (!found && leftCoin >= 1) {
                for (int v : b) {
                    if (a.contains(value - v)) {
                        a.remove(value - v);
                        b.remove(v);
                        leftCoin --;
                        found = true;
                        break;
                    }
                }
            }
            
            if (!found && leftCoin >= 2) {
                for (int v : b) {
                    if (b.contains(value - v) && b.contains(v)) {
                        found = true;
                        b.remove(value - v);
                        b.remove(v);
                        leftCoin -=2;
                        break;
                    }
                }
            }
            
            if (!found) {
                break;
            }
            round ++;
            currentIdx +=2;
        }
        
        return round;
    }
    
    

}

