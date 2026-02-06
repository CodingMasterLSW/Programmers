import java.io.*;
import java.util.*;

class Main {

    static boolean[][] graph = new boolean[105][105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int box = Integer.parseInt(br.readLine());

        for (int i=0; i<box; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = a; j < a + 10; j++) {
                for (int z = b; z < b + 10; z ++) {
                    graph[j][z] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (graph[i][j] == true) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}