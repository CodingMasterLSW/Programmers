class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String k =phone_number.substring(0, phone_number.length()-4).replaceAll(".","*");
        answer = k+phone_number.substring(phone_number.length()-4, phone_number.length());
            
        return answer;
    }
}