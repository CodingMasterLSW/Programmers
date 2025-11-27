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
        
        return result.entrySet().stream()
        .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())) 
        .map(Map.Entry::getKey)                                           
        .mapToInt(Integer::intValue)                                       
        .toArray();
    }
    
    public static Map<Integer, Integer> init(int N) {
        Map<Integer,Integer> maps = new HashMap<>();
        
        for (int i=1; i<=N+1; i++) {
            maps.put(i, 0);
        }
        return maps;
    }
}