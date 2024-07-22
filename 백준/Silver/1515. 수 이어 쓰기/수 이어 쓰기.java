import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int pt = 0;
        int current = 0;

        while(true){
            current++;
            String tmp = String.valueOf(current);

            for(int i=0; i<tmp.length(); i++){
                if(tmp.charAt(i) == s.charAt(pt)){
                    pt++;
                }
                if(s.length() == pt){
                    System.out.println(tmp);
                    return;
                }
            }
        }

    }

}
