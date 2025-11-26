import java.io.*;
import java.util.*;

class Main {

    static List<Egg> eggs = new ArrayList<>();
    static int breakEggCounts = 0;
    static int N;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(d, w));
        }
        recursion(0);
        System.out.println(breakEggCounts);
    }

    public static void recursion(int idx) {
        // 오른쪽 끝 계란인 경우
        if (idx == N) {
            int cnt = 0;
            for (Egg egg : eggs) {
                if (egg.isDestroy()) {
                    cnt++;
                }
            }
            breakEggCounts = Math.max(cnt, breakEggCounts);
            return;
        }

        // 손에 들고 있는 계란이 부서진 경우
        Egg current = eggs.get(idx);
        if (current.isDestroy()) {
            recursion(idx + 1);
            return;
        }

        boolean isHit = false;

        for (int i=0; i<N; i++) {
            // current 계란은 제외
            if (idx == i) {
                continue;
            }
            Egg target = eggs.get(i);
            
            // 이미 에그가 부셔진 경우
            if (target.isDestroy()) {
                continue;
            }
            isHit = true;
            
            // 내구도 감소 로직
            current.decreaseDuration(target.getWeight());
            target.decreaseDuration(current.getWeight());

            recursion(idx + 1);
            // 내구도 복구 로직
            current.increaseDuration(target.getWeight());
            target.increaseDuration(current.getWeight());
        }
        if (!isHit) {
            recursion(idx + 1);
        }
    }

}

class Egg {
    int duration;
    int weight;

    public Egg(int duration, int weight) {
        this.duration = duration;
        this.weight = weight;
    }

    public void decreaseDuration(int value) {
        this.duration -= value;
    }

    public void increaseDuration(int value) {
        this.duration += value;
    }

    public boolean isDestroy() {
        return duration <= 0;
    }

    public int getDuration() {
        return duration;
    }

    public int getWeight() {
        return weight;
    }
}