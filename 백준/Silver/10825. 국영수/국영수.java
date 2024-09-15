import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String[]> lists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            lists.add(s);
        }
        lists.sort((String[] a1, String[] a2) -> {
            if (a1[1].equals(a2[1])) {
                if (a1[2].equals(a2[2])) {
                    if (a1[3].equals(a2[3])) {
                        return a1[0].compareTo(a2[0]);
                    } else {
                        return (Integer.parseInt(a2[3]) - Integer.parseInt(a1[3]));
                    }
                } else {
                    return Integer.parseInt(a1[2]) - Integer.parseInt(a2[2]);
                }
            } else {
                return Integer.parseInt(a2[1]) - Integer.parseInt(a1[1]);

            }
        });

        for (String[] list : lists) {
            System.out.println(list[0]);
        }
    }

}
