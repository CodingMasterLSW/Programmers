class Solution {
    public int solution(int[] number) {
        int cnt = 0;
        for (int z=0; z < number.length - 2; z++) {
            for (int i=z+1; i<number.length - 1; i++) {
                if (i == z) {
                    continue;
                }
                for (int j=i+1; j<number.length; j++) {
                    if (number[z] + number[i] + number[j] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}

// -5, -2, 0, 2, 3 이렇게 정렬되어 있는 상태가 있을거고
//  