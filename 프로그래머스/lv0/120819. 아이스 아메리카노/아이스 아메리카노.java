class Solution {
    public int[] solution(int money){
        int coffee = 5500;
        int count = (money/coffee);
        int coin = money%coffee;
        return new int[]{count,coin};
    } 
}