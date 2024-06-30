import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> trash = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++){
            dq.offer(i);
        }

        while(dq.size()!=1){
            int top = dq.poll();
            trash.add(top);

            int newInsert = dq.poll();
            dq.addLast(newInsert);
        }

        StringBuilder sb = new StringBuilder();
        for(int t : trash){
            sb.append(t+" ");
        }
        sb.append(dq.poll());
        System.out.println(sb.toString());

    }

}
