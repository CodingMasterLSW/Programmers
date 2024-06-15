class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sp = s.split(" ");
        
        int[] arr = new int[sp.length];
        for(int i=0; i<sp.length; i++){
            arr[i] = Integer.parseInt(sp[i]);
        }
        
        int max = arr[0];
        int min = arr[0];
        
        for(int k : arr){
            if (k> max){
                max = k;
            }
            if (k<min){
                min = k;
            }
        }
        answer = String.valueOf(min)+" "+String.valueOf(max);
        
        return answer;
    }
}