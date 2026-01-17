import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;

        int[] currentArr = new int[3];
        while (true) {
            cnt++;
            //System.out.println("cnt = " + cnt);
            currentArr[0] = (currentArr[0] % 15) + 1;
            currentArr[1] = (currentArr[1] % 28) + 1;
            currentArr[2] = (currentArr[2] % 19) + 1;
        
            //System.out.println("Array = " + Arrays.toString(currentArr));
            
            if (E == currentArr[0] && S == currentArr[1] && M == currentArr[2]) {
                break;
            }
        }
        System.out.println(cnt);
    }
}