
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        int index = 0;
        int cnt = 0;
        
        while(index <= s1.length() - s2.length()){
            if(s1.substring(index, index+s2.length()).equals(s2)){
                cnt++;
                index+=s2.length();
            } else{
                index++;
            }
        }
        System.out.println(cnt);
    }
}
