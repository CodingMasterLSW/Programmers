import java.util.*;

class Solution {
    
    static Map<String, Integer> maps = new HashMap<>();
    static List<Integer> lists = new ArrayList<>();


    public int[] solution(String msg) {
        initDictionary(); //A~Z 초기화

        int idx = 0;

        boolean status = true;
        while(idx < msg.length()) {

            StringBuilder sb = new StringBuilder();
            StringBuilder tmp = new StringBuilder();

            while (status && idx<msg.length()) {

                tmp.setLength(0);
                tmp.append(sb.toString());

                sb.append(msg.charAt(idx));

                if (!maps.containsKey(sb.toString())) {
                    status = false;
                    continue;
                }
                idx++;
            }

            if(idx>= msg.length()){
                lists.add(maps.get(sb.toString()));
            } else {
                maps.put(sb.toString(), maps.size() + 1);
                lists.add(maps.get(tmp.toString()));
                status = true;
            }

        }


        int[] res = new int[lists.size()];
        for(int i=0; i<lists.size(); i++){
            res[i] = lists.get(i);
        }
        return res;
    }

    public static void initDictionary(){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i<s.length(); i++){
            maps.put(String.valueOf(s.charAt(i)), i+1);
        }
    }
}