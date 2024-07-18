import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visited = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            visited[i] = Integer.parseInt(st.nextToken());
        }

        int currentMax = 0;
        for(int i=0; i<X; i++){
            currentMax += visited[i];
        }
        int max = currentMax;
        int cnt = 1;

        for(int i=X; i<N; i++){
            currentMax += visited[i] - visited[i-X];
            if(currentMax>max){
                cnt = 1;
                max = currentMax;
            } else if(max == currentMax){
                cnt++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        } else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }

}
