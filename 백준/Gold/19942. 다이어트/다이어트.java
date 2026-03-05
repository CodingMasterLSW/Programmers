import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] min = new int[4];
    static Map<Integer, Food> foods = new HashMap<>();
    static List<Integer> arr = new ArrayList<>();
    static int minPrice = Integer.MAX_VALUE;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[4];
            for (int j=0; j<4; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            foods.put(i, new Food(i, tmp, Integer.parseInt(st.nextToken())));
        }

        for (int i=1; i<=N; i++) {
            backtracking(1, i);
        }
        
        if (minPrice == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int r : result) {
            sb.append(r).append(" ");
        }

        System.out.println(minPrice);
        System.out.println(sb.toString());
    }

    public static void backtracking(int start, int depth) {
        // 종료 조건
        if (arr.size() == depth) {
            cal();
            return;
        }

        for (int i=start; i<=N; i++) {
            arr.add(i);
            backtracking(i+1, depth);
            arr.remove(arr.size() -1);
        }
    }

    public static void cal() {
        int[] sum = new int[4];
        int prices = 0;
        int[] tmp = new int[arr.size()];
        
        int cnt = 0;
        for (int a : arr) {
            Food food = foods.get(a);
            for (int i=0; i<4; i++) {
                sum[i] += food.nut[i];
            }
            tmp[cnt] = food.name;
            prices += food.price;
            cnt++;
        }

        boolean isTarget = true;
        for (int i=0; i<4; i++) {
            if (sum[i] < min[i]) {
                isTarget = false;
                break;
            } 
        }

        if (isTarget) {
            if (minPrice >= prices) {
                if (minPrice == prices) {
                    // 비교 로직

                    int limit = Math.min(result.length, tmp.length);

                    for (int i=0; i<limit; i++) {
                        if (result[i] == tmp[i]) {
                            continue;
                        }

                        if (result[i] > tmp[i]) {
                            minPrice = prices;
                            result = tmp.clone();
                            break;
                        }
                        break;
                    }
                } else {
                    minPrice = prices;
                    result = tmp.clone();
                }
            }
        }
    }
}

class Food {
    int name;
    int[] nut;
    int price;

    public Food(int name, int[] nut, int price) {
        this.name = name;
        this.nut = nut;
        this.price = price;
    }
}