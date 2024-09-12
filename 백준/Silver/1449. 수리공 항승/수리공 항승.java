import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> lists = new ArrayList<>();
        for(int i=0; i<N; i++) {
            lists.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(lists);
        int startIdx = 0;
        for(int i=0; i<lists.size(); i++){
            if(Math.abs(lists.get(startIdx) - lists.get(i))<L){
                continue;
            } else{
                startIdx = i;
                cnt++;
            }
        }
        System.out.println(cnt+1);
    }

}
