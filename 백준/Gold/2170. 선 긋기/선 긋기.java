import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        Long[][] lines = new Long[k][2];

        for(int i=0; i<k; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            lines[i][0] = Long.parseLong(st1.nextToken());
            lines[i][1] = Long.parseLong(st1.nextToken());
        }

        // 시작 줄로부터 정렬
        Arrays.sort(lines, (a,b) -> {
            if(a[0] != b[0]){
                return Math.toIntExact(a[0] - b[0]);
            } else{
                return Math.toIntExact(a[1] - b[1]);
            }
        });


        Long startLine = lines[0][0];
        Long endLine = lines[0][1];
        Long sumLine = 0L;

        for(int i=1; i<k; i++){
            if(lines[i][0] > endLine){
                sumLine += endLine - startLine;
                startLine = lines[i][0];
                endLine = lines[i][1];
            } else if(lines[i][1] > endLine){
                endLine = lines[i][1];
            }
        }
        sumLine += endLine - startLine; // 마지막 선분 추가
        bw.write(String.valueOf(sumLine));
        bw.flush();
        bw.close();

    }

}
