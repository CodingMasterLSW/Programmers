import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<String[]> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] divS = s.split(" ");
            lists.add(divS);
        }

        Comparator<String[]> comparator = (a, b) -> {
            int year = Integer.compare(Integer.parseInt(a[3]), Integer.parseInt(b[3]));
            if (year != 0) {
                return year;
            }

            int month = Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
            if (month != 0){
                return month;
            }
            return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
        };
        lists.sort(comparator);

        System.out.println(lists.get(N-1)[0]);
        System.out.println(lists.get(0)[0]);
    }

}
