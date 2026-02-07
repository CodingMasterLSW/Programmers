import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] dirs = new int[6];
        int[] lens = new int[6];

        for (int i=0; i<6; i++) { 
            StringTokenizer st = new StringTokenizer(br.readLine());
            dirs[i] = Integer.parseInt(st.nextToken());
            lens[i] = Integer.parseInt(st.nextToken());
        }
    

        int maxX = 0;
        int maxXIdx = -1;
        int maxY = 0;
        int maxYIdx = -1;

        for (int i=0; i<6; i++) {
            if (dirs[i] == 1 || dirs[i] == 2) {
                if (lens[i] > maxX) {
                    maxX = lens[i];
                    maxXIdx = i;
                }
            } else {
                if (lens[i] > maxY) {
                    maxY = lens[i];
                    maxYIdx = i;
                }
            }
        }
        int maxSqure = maxX * maxY;


        // 0의 경우, 끝 인덱스로 가야한다.
        // 마지막 인덱스의 경우, 0으로 가야한다.


        int minX = Math.abs((lens[(maxXIdx -1 + 6) % 6] - lens[(maxXIdx + 1 + 6) % 6]));
        int minY = Math.abs((lens[(maxYIdx -1 + 6) % 6] - lens[(maxYIdx + 1 + 6) % 6]));

        int minSqure = minX * minY;

        System.out.println((maxSqure - minSqure) * K);
    }
}