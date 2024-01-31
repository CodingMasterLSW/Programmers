

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static List<String> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            lists.add(br.readLine());
        }
        Set<String> set = new HashSet<>(lists);
        List<String> uniqueLists = new ArrayList<>(set);

        Collections.sort(uniqueLists, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return Integer.compare(a.length(), b.length());
            }
        });

       for(String i : uniqueLists){
           System.out.println(i);
       }
    }
}
