import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> lists = new ArrayList<>();

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>0; i--){
            lists.add(arr[i-1],i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : lists){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());


    }

}
