import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> lists = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            lists.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int cnt = 0;

        while (end < lists.size()) {
            if (sum < N) {
                sum += lists.get(end);
                if(sum==N){
                    cnt++;
                }
                end++;
            }
            if (sum >= N) {
                sum -= lists.get(start);
                if(sum==N){
                    cnt++;
                }
                start++;
            }
        }
        System.out.println(cnt);
    }

}
