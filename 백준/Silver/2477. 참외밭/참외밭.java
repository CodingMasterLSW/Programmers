import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());

        List<int[]> lists = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            lists.add(arr);
        }

        int maxIdx1 = 0;
        int maxIdx2 = 0;
        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < 6; i++) {
            if (lists.get(i)[0] == 1 || lists.get(i)[0] == 2) {
                if (lists.get(i)[1] > max1) {
                    max1 = lists.get(i)[1];
                    maxIdx1 = i;
                }
            } else {
                if(lists.get(i)[1] > max2){
                    max2 = lists.get(i)[1];
                    maxIdx2 = i;
                }
            }
        }

        int sLength = 0;
        int sWidth = 0;

        if(maxIdx1 == 0){
            sLength = Math.abs(lists.get(1)[1] - lists.get(5)[1]);
        } else if (maxIdx1 == 5){
            sLength = Math.abs(lists.get(4)[1] - lists.get(0)[1]);
        } else{
            sLength = Math.abs(lists.get(maxIdx1-1)[1] - lists.get(maxIdx1+1)[1]);
        }

        if(maxIdx2 == 0){
            sWidth = Math.abs(lists.get(1)[1] - lists.get(5)[1]);
        } else if (maxIdx2 == 5){
            sWidth = Math.abs(lists.get(4)[1] - lists.get(0)[1]);
        } else{
            sWidth = Math.abs(lists.get(maxIdx2-1)[1] - lists.get(maxIdx2+1)[1]);
        }

        int minSquare = sWidth * sLength;

        int square = max1 * max2;

        int finalSquare = (square - minSquare)* price;

        System.out.println(finalSquare);
    }

}
