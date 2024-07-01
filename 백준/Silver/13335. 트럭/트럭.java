import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int l = sc.nextInt();

        Queue<Integer> truck = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            truck.offer(sc.nextInt());
        }

        Queue<int[]> bridge = new LinkedList<>();

        int time = 0;
        int totalWeightOnBridge = 0;

        while (!truck.isEmpty() || !bridge.isEmpty()) {
            time++;

            if (!bridge.isEmpty() && bridge.peek()[1] == w) {
                totalWeightOnBridge -= bridge.poll()[0];
            }

            if (!truck.isEmpty() && totalWeightOnBridge + truck.peek() <= l && bridge.size() < w) {
                int newTruck = truck.poll();
                bridge.offer(new int[]{newTruck, 0});
                totalWeightOnBridge += newTruck;
            }

            for (int[] b : bridge) {
                b[1]++;
            }

        }

        System.out.println(time);
    }

}
