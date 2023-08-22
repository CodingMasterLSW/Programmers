import java.util.Arrays;

class Solution {
    public int[] solution(String[] strList) {
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}