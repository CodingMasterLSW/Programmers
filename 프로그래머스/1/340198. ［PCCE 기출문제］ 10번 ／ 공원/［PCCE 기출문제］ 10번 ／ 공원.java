import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for (int z=0; z<mats.length; z++) {
            int currentSize = mats[mats.length-1-z];
            
            for (int i=0; i<park.length; i++) {
                for (int j=0; j<park[0].length; j++) {
                    if (search(currentSize, i, j, park)) {
                        return currentSize;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean search(int matSize, int row, int col, String[][] park) {
        if (col + matSize > park[0].length) {
            return false;
        }
        if (row + matSize > park.length) {
            return false;
        }
        
        for (int i=0; i<matSize; i++) {
            for (int j=0; j<matSize; j++) {
                if (!park[row + i][col + j].equals("-1")) {
                    return false;
                } 
            }
        }
        return true;
         
    }
}