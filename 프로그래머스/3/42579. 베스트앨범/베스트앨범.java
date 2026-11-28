import java.util.*;

// 1) Genres 별로 sum을 할 수 있어야함.
// 2) 각 Genres 별로 2개까지 기록을 해야함.

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Histories> maps = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            if (maps.get(genres[i]) == null) {
                maps.put(genres[i], new Histories());
                maps.get(genres[i]).add(new int[]{plays[i], i});
            } else {
                maps.get(genres[i]).add(new int[]{plays[i], i});
            }
        }
        
        Queue<Integer> tmp = new ArrayDeque<>();
        int genreCount = maps.size();
        
        for (int i=0; i<genreCount; i++) {
            String max = "";
            for (String key : maps.keySet()) {
                if (maps.get(max) == null) {
                    max = key;
                    continue;
                }
                int v1 = maps.get(max).calMax();
                int v2 = maps.get(key).calMax();
                if (v1 < v2) {
                    max = key;
                }
            }
            List<int[]> arr = maps.get(max).maxTwo();
            for (int[] a : arr) {
                tmp.offer(a[1]);
            }
            maps.remove(max);
        }

    
        int[] answer = new int[tmp.size()];
        int cnt = 0;
        while(!tmp.isEmpty()) {
            answer[cnt] = tmp.poll();
            cnt++;
        }

        return answer;
    }
}

class Histories {
    
    List<int[]> histories = new ArrayList<>();
    
    public void add(int[] values) {
        histories.add(values);
    } 
    
    public List<int[]> maxTwo() {
        List<int[]> result = new ArrayList<>();
        
        Collections.sort(histories, (a, b) -> Integer.compare(b[0], a[0]));
        if (histories.size() < 2) {
            if (histories.size() == 1) {
                result.add(histories.get(0));
                return result;
            } else if (histories.size() == 0) {
                return result;
            }
        }
        result.add(histories.get(0));
        result.add(histories.get(1));
        return result;
    }
    
    public int calMax() {
        int sum = 0;
        
        for (int[] history : histories) {
            sum += history[0];
        }
        return sum;
    }
    
    public void print() {
        for (int[] h : histories) {
            System.out.println(h[0]);
        }
    }
}

// 내가 기록해야 하는 것 : Genres 별 합 Map<String, Integer> -> 이건 기록 가능
// 플레이어 위치는 어떻게 기록? -> Map<String, int[]> 이렇게? 