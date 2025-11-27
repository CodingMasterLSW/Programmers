import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> maps = init(N);
                
        for (int stage : stages) {
            maps.put(stage, maps.get(stage) + 1);
        }        
        
        int currentValue = stages.length;
        
        Map<Integer, Double> result = new HashMap<>();
        
        for (int i=1; i<=N; i++) {
            int divideValue = maps.get(i);
            if (divideValue == 0) {
                result.put(i, 0.0);
                continue;
            }
            double failValue = (double) divideValue / currentValue;
            result.put(i, failValue);
            currentValue -= maps.get(i);
        }
        
        System.out.println(result);
        
        int[] arr = new int[N];
        
        int idx = 0;
        
        while(idx != N) {
            int maxKey = 0;
            double maxValue = -0.1;
            for (int i=1; i<=N; i++) {
                if (result.get(i) == null) {
                    continue;
                }
                if (result.get(i) > maxValue) {
                    maxValue = result.get(i);
                    maxKey = i;
                }
            }
            result.remove(maxKey);
            arr[idx] = maxKey;
            idx++;
        }
        return arr;
    }
    
    public static Map<Integer, Integer> init(int N) {
        Map<Integer,Integer> maps = new HashMap<>();
        
        for (int i=1; i<=N+1; i++) {
            maps.put(i, 0);
        }
        return maps;
    }
}