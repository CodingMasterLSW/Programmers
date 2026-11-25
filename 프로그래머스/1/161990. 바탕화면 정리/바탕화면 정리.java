// 최소, 최댓값 구하고 절댓값 연산 ㄱㄱ

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        
        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '.') {
                    continue;
                }
                minR = Math.min(minR, i);
                maxR = Math.max(maxR, i);
                minC = Math.min(minC, j);
                maxC = Math.max(maxC, j);          
            }
        }
       
        
        return new int[]{minR, minC, maxR+1, maxC+1};
 
    }
}