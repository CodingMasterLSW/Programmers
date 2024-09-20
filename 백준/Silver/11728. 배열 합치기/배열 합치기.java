import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        List<Integer> lists = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a1; i++){
            lists.add(Integer.parseInt(st.nextToken()));
        }
        st=  new StringTokenizer(br.readLine());
        for(int i=0; i<a2; i++){
            lists.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(lists);

        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list+" ");
        }
        System.out.println(sb.toString());
    }

}
