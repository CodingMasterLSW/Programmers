import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> lists = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists.add(new int[]{x,y});
        }
        lists.sort((a1,a2) -> {
            if(a1[1] == a2[1]){
                return a1[0] - a2[0];
            }
            return a1[1] - a2[1];
        });

        for(int[] list : lists){
            System.out.println(list[0]+" "+list[1]);
        }
    }

}