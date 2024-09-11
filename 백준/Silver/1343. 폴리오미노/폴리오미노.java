import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = find(s);
        if(k == -1){
            System.out.println(-1);
        } else {

            System.out.println(sb.toString());
        }
    }

    public static int find(String s) {
        int idx = 0;
        for(char c : s.toCharArray()){
            if(c == '.'){
                while(idx>0){
                    if(idx>=4){
                        sb.append("AAAA");
                        idx-=4;
                    } else if(idx%2==0){
                        sb.append("BB");
                        idx-=2;
                    } else{
                        return -1;
                    }
                }
                sb.append(".");
            } else {
                idx++;
            }
        }
        while(idx>0){
            if(idx>=4){
                sb.append("AAAA");
                idx-=4;
            } else if(idx%2==0){
                sb.append("BB");
                idx-=2;
            } else{
                return -1;
            }
        }
        return 0;
    }
}
