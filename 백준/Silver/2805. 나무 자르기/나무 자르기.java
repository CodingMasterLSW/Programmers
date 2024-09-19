import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> trees = new ArrayList<>();
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<N; i++){
            int tree = Integer.parseInt(st.nextToken());
            end = Math.max(tree, end);
            trees.add(tree);
        }

        while(start<=end){
            int currentTree = (start+end)/2;
            long sum = 0;

            for(int tree : trees){
                if(tree - currentTree > 0){
                    sum += (tree - currentTree);
                }
            }
            if(sum<M){
                end = currentTree-1;
            } else{
                start = currentTree+1;
            }
        }
        System.out.println(end);
    }

}
