import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {

        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(String record : records){
            String[] splitRecord = record.split(" ");

            String parkTime = splitRecord[0];
            int carNum = Integer.parseInt(splitRecord[1]);
            String inOut = splitRecord[2];

            if(!map1.containsKey(carNum) && inOut.equals("IN")){
                map1.put(carNum, parkTime);
            } else{

                if(inOut.equals("OUT")){
                    String num1 = map1.get(carNum);
                    String num2 = parkTime;

                    int calNum1 = calTime(num1);
                    int calNum2 = calTime(num2);

                    if(map2.get(carNum) == null){
                        map2.put(carNum, calNum2 - calNum1);

                    } else{
                        map2.put(carNum, map2.get(carNum) + (calNum2 - calNum1));
                    }
                    map1.remove(carNum);
                }
            }

        }
        if(!map1.isEmpty()){
            for(int carNum : map1.keySet()){
                String num1 = map1.get(carNum);
                String num2 = "23:59";
                int calNum1 = calTime(num1);
                int calNum2 = calTime(num2);

                if(map2.get(carNum) == null){
                    map2.put(carNum, calNum2 - calNum1);
                } else {
                    map2.put(carNum, map2.get(carNum) + (calNum2 - calNum1));
                }
            }
        }

        for(int a : map2.keySet()){
            int calPrice = calPrice(fees, map2.get(a));
            //System.out.println("calPrice = " + calPrice);
            map2.put(a, calPrice);
        }

        List<Integer> lists = new ArrayList<>(map2.keySet());
        Collections.sort(lists);

        int[] answer = new int[lists.size()];

        int idx = 0;
        for(int list : lists){
            answer[idx] = map2.get(list);
            idx++;
            //System.out.println(answer[idx]);
        }
        return answer;
    }


    public static int calTime(String input){
        String[] split = input.split(":");
        int time = 0;
        time += Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
        return time;
    }

    public static int calPrice(int[] fees, int totalTime){
        if(totalTime<=fees[0]){
            return fees[1];
        }
        int totalTimeOverBase = totalTime - fees[0];
        double extraCharges = Math.ceil((double) totalTimeOverBase / fees[2]) * fees[3];
        int totalPrice = (int) (fees[1] + extraCharges);
        return totalPrice;
    }
}