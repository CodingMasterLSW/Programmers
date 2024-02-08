
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            int k = Integer.parseInt(br.readLine());
            if(k==0){
                if(q.isEmpty()){
                    bw.write(String.valueOf(0));
                    bw.newLine();
                } else{
                    bw.write(String.valueOf(q.poll()));
                    bw.newLine();
                }
            } else{
                q.add(k);
            }
        }
        bw.flush();
        bw.close();

    }

}
