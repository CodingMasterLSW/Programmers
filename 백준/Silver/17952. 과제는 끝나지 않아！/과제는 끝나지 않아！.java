import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Task> deq = new ArrayDeque<>();
        int totalScore = 0;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String validator = st.nextToken();
            if (!validator.equals("0")) {
                int score = Integer.parseInt(st.nextToken());
                int leftTime = Integer.parseInt(st.nextToken());
                deq.push(new Task(score, leftTime));
            }

            if (!deq.isEmpty()) {
                Task current = deq.peek();
                current.decreaseTime();
                
                if (current.getLeftTime() == 0) {
                    totalScore += current.getScore();
                    deq.pop();
                }
            }
        }

        System.out.println(totalScore);
    }
}

class Task {
    private int score;
    private int leftTime;

    public Task(int score, int leftTime) {
        this.score = score;
        this.leftTime = leftTime;
    }

    public void decreaseTime() {
        this.leftTime --;
    }

    public int getScore() {
        return score;
    }

    public int getLeftTime() {
        return leftTime;
    }

    @Override
    public String toString() {
        return "score: " + score + ", leftTime: " + leftTime;
    }
}