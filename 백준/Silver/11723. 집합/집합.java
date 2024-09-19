import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Set<Integer> sets = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            String calculator = "";
            int number = 0;
            if(split.length==2){
                number = Integer.parseInt(split[1]);
            }
            calculator = split[0];

            if (calculator.equals("add")) {
                sets.add(number);
            } else if (calculator.equals("remove")) {
                sets.remove(number);
            } else if (calculator.equals("check")){
                if(sets.contains(number)){
                    sb.append("1\n");
                } else{
                    sb.append("0\n");
                }
            } else if (calculator.equals("toggle")) {
                if(sets.contains(number)){
                    sets.remove(number);
                } else{
                    sets.add(number);
                }
            } else if(calculator.equals("empty")){
                sets.clear();
            } else if(calculator.equals("all")){
                sets.clear();
                for(int j=1; j<=20; j++){
                    sets.add(j);
                }
            }
        }
        System.out.println(sb.toString());
    }

}
