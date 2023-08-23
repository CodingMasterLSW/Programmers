class Solution {
    public String solution(String my_string) {
        int n = my_string.length();
        char[] arr = my_string.toCharArray();
        char[] reversedArr = new char[n];

        for (int i = 0; i < n; i++) {
            reversedArr[i] = arr[n - 1 - i];
        }

        String result = new String(reversedArr);
        return result;
    }
}