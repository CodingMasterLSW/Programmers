import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Task> tasks = new ArrayList<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            tasks.add(new Task(deadLine, amount));
        }

        Collections.sort(tasks, (a, b) -> a.deadLine - b.deadLine);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int currentTask = 0;
        for (Task task : tasks) {
            pq.offer(task.amount);
            if (pq.size() > task.deadLine) {
                pq.poll();
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}

class Task {
    int deadLine;
    int amount;

    public Task(int deadLine, int amount) {
        this.deadLine = deadLine;
        this.amount = amount;
    }
}