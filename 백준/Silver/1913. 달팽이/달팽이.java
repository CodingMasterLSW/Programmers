import java.io.*;

public class Main {

    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[] res = new int[2];

        graph = new int[N][N];

        int start = N*N;
        int idx = 0;
        while(true){
            // ↑
            for(int i=idx; i<N-idx; i++){
                graph[i][idx] = start;
                if(start==find){
                    res[0] = i;
                    res[1] = idx;
                }
                start--;
            }
            // →
            for(int i=idx+1; i<N-1-idx; i++){
                graph[N-1-idx][i] = start;
                if(start == find){
                    res[0] = N-1-idx;
                    res[1] = i;
                }
                start--;
            }
            // ↓
            for(int i=N-1-idx; i>-1+idx; i--){
                graph[i][N-1-idx] = start;
                if(start == find){
                    res[0] = i;
                    res[1] = N-1-idx;
                }
                start--;
            }
            // ←
            for(int i=N-2-idx; i>idx; i--){
                graph[idx][i] = start;
                if(start == find){
                    res[0] = idx;
                    res[1] = i;
                }
                start--;
            }
            idx++;

            if(start == 1){
                graph[idx][idx] = 1;
                if(find == 1){
                    res[0] = idx;
                    res[1] = idx;
                }
                break;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(graph[i][j] +" ");
            }
            bw.newLine();
        }
        bw.write((res[0]+1)+" "+ (res[1]+1));
        bw.flush();
        bw.close();
    }


}
