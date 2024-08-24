class Solution {
    public int solution(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        
        int currentLCM = arr[0];
        
        for(int i=1; i<arr.length; i++){
            int currentGCD = gcp(currentLCM, arr[i]);
            int maxLCM = currentGCD * (currentLCM / currentGCD) * (arr[i] / currentGCD);
            currentLCM = maxLCM;
        }
        
        return currentLCM;
    }
    
    public int gcp(int n, int m){
        while(m != 0){
            int temp = m;
            m = n%m;
            n = temp;
        }
        return n;
    }
}