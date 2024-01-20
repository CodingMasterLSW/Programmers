import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                plusList.add(x);
            } else {
                minusList.add(x);
            }
        }
        int finalResult = 0;
        Collections.sort(plusList, Collections.reverseOrder());
        Collections.sort(minusList);

        for(int i=0; i< minusList.size()-1; i+=2){
             finalResult += minusList.get(i) * minusList.get(i + 1);
        }

        if(minusList.size()%2 != 0){
            finalResult+=minusList.get(minusList.size()-1);
        }

        for(int i=0; i< plusList.size()-1; i+=2){
            if(plusList.get(i)==1 || plusList.get(i+1)==1){
                finalResult += (plusList.get(i)+ plusList.get(i+1));
            } else{
                finalResult += (plusList.get(i) * plusList.get(i+1));
            }
        }

        if(plusList.size()%2 != 0){
            finalResult += plusList.get(plusList.size()-1);
        }

        bw.write(String.valueOf(finalResult));
        bw.flush();
        bw.close();


    }


}