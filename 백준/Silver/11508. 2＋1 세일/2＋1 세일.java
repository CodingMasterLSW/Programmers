import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();

        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr, Collections.reverseOrder());

        int sum = 0;

        for (int i=1; i<=arr.size(); i++) {
            if (i%3 == 0) {
                continue;
            }
            sum += arr.get(i-1);
        }
 
        System.out.println(sum);
    }

}