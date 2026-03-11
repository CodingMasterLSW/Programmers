import java.io.*;
import java.util.*;

class Main {

    static List<Integer> arr = new ArrayList<>();
    static int tmpValue = 0;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        backtracking();
        System.out.println(maxValue);
    }

    public static void backtracking() {
        // 종료 조건?
        if (arr.size() <= 2) {
            maxValue = Math.max(maxValue, tmpValue);
            return;
        }

        for (int i=1; i < arr.size() -1; i++) {
            int cal = arr.get(i-1) * arr.get(i+1);
            tmpValue += cal;
            int removeValue = arr.remove(i);
            backtracking();
            arr.add(i, removeValue);
            tmpValue -= cal;
        }
    }
}