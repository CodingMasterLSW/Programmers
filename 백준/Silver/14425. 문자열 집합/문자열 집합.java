import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> arr = new HashSet<>();
        for (int i=0; i<n; i++) {
            arr.add(br.readLine());
        }

        int cnt = 0;
        for (int i=0; i<m; i++) {
            if(arr.contains(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}