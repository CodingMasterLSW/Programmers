import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String kind = sc.next();

        Set<String> sets = new HashSet<>();
        for(int i=0; i<N; i++){
            sets.add(sc.next());
        }

        if(kind.equals("Y")){
            System.out.println(sets.size());
        }
        else if(kind.equals("F")){
            System.out.println(sets.size()/2);
        }
        else{
            System.out.println(sets.size()/3);
        }
    }

}
