import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        List<Character> ch = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='<'){
                if(ch.size()!=0){
                    for(int z = ch.size()-1; z>-1; z--){
                        sb.append(ch.get(z));
                    }
                    ch.clear();
                }
                while(s.charAt(i) != '>'){
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append('>');
            } else{
                if(c==' ' || i== s.length()-1){
                    if(i==s.length()-1){
                        ch.add(c);
                    }
                    for(int z = ch.size()-1; z>-1; z--){
                        sb.append(ch.get(z));
                    }
                    sb.append(' ');
                    ch.clear();
                } else{
                    ch.add(c);
                }

            }
        }
        System.out.println(sb.toString());
    }

}
