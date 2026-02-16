import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        Map<Integer, Cow> cows = new HashMap<>();

        for (int i=1; i<=10; i++) {
            cows.put(i, new Cow(i));
        }


        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());

            Cow cow = cows.get(cowNum);
            cow.histories.add(move);
        }


        int cnt = 0;
        for (int cowNum : cows.keySet()) {
            Cow cow = cows.get(cowNum);
            if (cow.isMoved()) {
                cnt += cow.calculateMaxValue();
            }
        }
        System.out.println(cnt);
    }
}

class Cow {
    int name;
    List<Integer> histories = new ArrayList<>();

    public Cow(int name) {
        this.name = name;
    }

    public boolean isMoved() {
        return histories.size() > 1;
    }

    public int calculateMaxValue() {
        int cnt = 0;
        for (int i=0; i< histories.size() -1; i++) {
            if (histories.get(i) != histories.get(i+1)) {
                cnt++;
            }
        }
        return cnt;
    }
}