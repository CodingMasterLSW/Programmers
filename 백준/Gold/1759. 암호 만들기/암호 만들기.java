import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static String[] result;
    static String[] arr;
    static List<String> vowel = List.of("a", "i", "e", "o", "u");
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new String[N];
        arr = new String[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        recursion(0, 0);
        System.out.println(sb.toString());
    }

    public static void recursion(int depth, int start) {
        if (depth == N) {
            int v = 0;
            int c = 0;
            for (String r : result) {
                if (vowel.contains(r)) {
                    v++;
                } else {
                    c++;
                }
            }
            if (v >= 1 && c >=2) {
                for (String r : result) {
                    sb.append(r);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i=start; i<M; i++) {
            result[depth] = arr[i];
            recursion(depth + 1, start+=1);
        }
    }
}