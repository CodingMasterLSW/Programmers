import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N - 1;
        long nearRes = Long.MAX_VALUE; //근사값 초기화
        List<Integer> res = new ArrayList<>();

        while (start < end) {
            long sum = arr[start] + arr[end];
            if (Math.abs(sum) < nearRes) {
                nearRes = Math.abs(sum);
                res.clear();
                res.add(arr[start]);
                res.add(arr[end]);
            }
            if (sum >= 0) {
                end--;
            } else if (sum < 0) {
                start++;
            }
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for (Integer re : res) {
            sb.append(re).append(" ");
        }
        System.out.println(sb.toString());

    }

}
