import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초밥 종류 중복 가능
        // 임의 위치 ~ k개 접시 : 할인된 정액 가격

        // 가능한 한 다양한 종류의 초밥 먹기
        // 쿠폰에 적힌 것이 없으면 +1

        // 8 30 4 30 ->
        // 접시 수 N, 가짓수 d , 연속 접시 k, 쿠폰번호 C
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        // 초밥 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> maps = new HashMap<>();

        int maxSize = 0;
        for (int i = 0; i < K; i++) {
            maps.put(arr[i], maps.getOrDefault(arr[i], 0) + 1);
        }
        
        if (!maps.containsKey(C)) {
            maxSize++;
        }
        maxSize += maps.size();

        int start = 0;
        int end = K;

        for (int i = 0; i < N; i++) {
            int tmpSize = 0;
            // start 삭제

            if (maps.get(arr[start]) > 1) {
                maps.put(arr[start], maps.get(arr[start]) - 1);
            } else {
                maps.remove(arr[start]);
            }
            // end 추가
            maps.put(arr[end % N], maps.getOrDefault(arr[end % N], 0) + 1);
            start++;
            end++;
            if(!maps.containsKey(C)){
                tmpSize ++;
            }
            tmpSize += maps.size();
            if(tmpSize>maxSize){
                maxSize = tmpSize;
            }
        }
        System.out.println(maxSize);
    }

}
