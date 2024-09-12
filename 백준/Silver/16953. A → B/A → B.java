import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int cnt = 0;

        while(B>A){
            StringBuilder sb = new StringBuilder();
            String s = String.valueOf(B);
            if(s.charAt(s.length()-1) == '1'){
                sb.append(s);
                sb.deleteCharAt(s.length()-1);
                B = Long.parseLong(sb.toString());
                cnt++;
            } else{
                if(B%2==0) {
                    B = Long.parseLong(s) / 2;
                    cnt++;
                } else{
                    break;
                }
            }
        }
        if(B!=A){
            System.out.println(-1);
        } else {
            System.out.println(cnt + 1);
        }
    }

}