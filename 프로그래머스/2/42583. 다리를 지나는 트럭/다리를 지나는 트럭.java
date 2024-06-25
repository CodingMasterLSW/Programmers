import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck = new LinkedList<>();

        for(int q : truck_weights){
            truck.offer(q);
        }

        Queue<int[]> bridge = new LinkedList<>();

        int answer = 1;

        while(true){
            answer++;

            if(!truck.isEmpty()){
                if (weight >= truck.peek() && bridge_length > bridge.size()) {
                    weight -= truck.peek();
                    bridge.offer(new int[]{truck.poll(), 0});
                }
            }


            for(int[] b : bridge){
                b[1]++;
            }

            if(bridge.peek()[1]==bridge_length){
                weight+=bridge.peek()[0];
                bridge.poll();
            }
            if(bridge.isEmpty() && truck.isEmpty()){
                break;
            }

        }
        System.out.println(answer);
        return answer;
    }
}