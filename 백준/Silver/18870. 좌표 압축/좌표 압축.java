import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr1[i];
        }

        Arrays.sort(arr2);

        Map<Integer, Integer> maps = new HashMap<>();

        int rank = 0;

        int current = arr2[0];
        maps.put(current, rank);
        for(int i=1; i<N; i++){
            if(arr2[i] == current){
                maps.put(current, rank);
            } else{
                rank++;
                current = arr2[i];
                maps.put(arr2[i], rank);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(maps.get(arr1[i])+" ");
        }

        System.out.println(sb.toString());

    }

}
