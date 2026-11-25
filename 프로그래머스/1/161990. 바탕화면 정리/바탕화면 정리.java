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
                minR = Math.min(minR, j);
                maxR = Math.max(maxR, j);
                minC = Math.min(minC, i);
                maxC = Math.max(maxC, i);          
            }
        }
        // System.out.println("minR = " + minR);
        // System.out.println("maxR = " + maxR);
        // System.out.println("minC = " + minC);
        // System.out.println("maxC = " + maxC);
        
        return new int[]{minC, minR, maxC+1, maxR+1};
 
    }
}