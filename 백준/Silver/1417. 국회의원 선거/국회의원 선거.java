import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> peoples = new ArrayList<>();

        int winner = sc.nextInt();

        for(int i=1; i<N; i++){
            int people = sc.nextInt();
            peoples.add(people);
        }

        if(peoples.isEmpty()){
            System.out.println(0);
            return;
        }
        Collections.sort(peoples, Collections.reverseOrder());

        int cnt = 0;
        while(winner<=peoples.get(0)){
            peoples.set(0, peoples.get(0)-1);
            Collections.sort(peoples, Collections.reverseOrder());
            cnt++;
            winner++;
        }
        System.out.println(cnt);
    }

}
