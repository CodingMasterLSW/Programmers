
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        s1 = s1.replaceAll(s2,"1");

        int cnt = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)=='1'){
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
