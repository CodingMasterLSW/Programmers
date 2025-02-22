
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }
        
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Integer a : arr) {
            sb.append(a + "\n");
        }
        System.out.println(sb.toString());
    }
}
