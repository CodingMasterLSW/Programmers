import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        sc.nextLine();

        List<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            ranks.add(new Rank(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }

        Collections.sort(ranks, (o1, o2) -> o2.score - o1.score);
        Map<Integer, Integer> winners = new HashMap<>();

        int count = 0;
        while (true) {
            for (Rank rank : ranks) {
                winners.put(rank.getCountry(), winners.getOrDefault(rank.getCountry(), 0) + 1);
                if (winners.get(rank.getCountry()) > 2) {
                    continue;
                }
                System.out.println(rank.toString());
                count ++;
                if (count == 3) {
                    return;
                }
            }
        }
    }


    public static class Rank {

        public int country;
        public int name;
        public int score;

        public Rank(final int country, final int name, final int score) {
            this.country = country;
            this.name = name;
            this.score = score;
        }

        public int getCountry() {
            return country;
        }

        public int getName() {
            return name;
        }

        public int getScore() {
            return score;
        }


        @Override
        public String toString() {
            return country + " " + name;
        }
    }


}



