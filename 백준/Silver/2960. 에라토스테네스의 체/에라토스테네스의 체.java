import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            arr.add(i);
        }

        int cnt = 0;
        int start = arr.get(0);
        while (true) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % start == 0) {
                    cnt++;
                    int remove = arr.remove(i);
                    i--;
                    if (cnt == K) {
                        System.out.println(remove);
                        break;
                    }
                }
            }
            if(cnt == K){
                break;
            } else {
                start = arr.get(0);
            }
        }
    }

}
