class Solution {
    public int solution(int[] wallet, int[] bill) {
        int maxWallet = Math.max(wallet[0], wallet[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);
        int currentBill1 = Math.max(bill[0], bill[1]);
        int currentBill2 = Math.min(bill[0], bill[1]);
        
        int cnt = 0;
        
        while(true) {
            int cb1 = Math.max(currentBill1, currentBill2);
            int cb2 = Math.min(currentBill1, currentBill2);
            int wt1 = Math.max(maxWallet, minWallet);
            int wt2 = Math.min(maxWallet, minWallet);
            
            // System.out.println("maxBill = " + cb1);
            // System.out.println("minBill = " + cb2);
            // System.out.println();
            if (cb1 <= wt1 && cb2 <= wt2) {
                break;
            }
            cnt ++;
            
            if (wt1 < cb1 || wt2 < cb2) {
                if (currentBill1 > currentBill2) {
                    currentBill1 /= 2;
                } else {
                    currentBill2 /= 2;
                }
            }
        }
        return cnt;
    }
}

