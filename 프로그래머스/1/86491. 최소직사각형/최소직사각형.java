
class Solution {
    public int solution(int[][] sizes) {
        
        int[] width = new int[sizes.length];
        int[] height= new int[sizes.length];
        
        int idx = 0;
        for(int[] size : sizes){
            width[idx] = Math.max(size[0],size[1]);
            height[idx] = Math.min(size[0],size[1]);
            idx++;
        }
        
        int widMax = width[0];
        int heightMax = height[0];
        
        for(int w : width){
            if(w>widMax){
                widMax = w;
            }
        }
        
        for(int h :height){
            if(h>heightMax){
                heightMax = h;
            }
        }
        
        return heightMax*widMax;
    }
}