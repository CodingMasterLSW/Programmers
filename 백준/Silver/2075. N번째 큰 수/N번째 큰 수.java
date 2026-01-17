import java.io.*;
import java.util.*;

class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(arr.size() - N));
    }
}