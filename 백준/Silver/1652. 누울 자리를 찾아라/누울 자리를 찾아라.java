import java.io.*;

public class Main {

    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < N; i++) {
            int current = 0;
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 'X'){
                    if(current>=2){
                        cnt1++;
                    }
                    current = 0;

                } else {
                    current++;
                }
                if (j == N - 1) {
                    if(current>=2){
                        cnt1++;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            int current = 0;
            for(int j=0; j<N; j++){
                if(graph[j][i] == 'X'){
                    if(current>=2){
                        cnt2++;
                    }
                    current = 0;

                } else {
                    current++;
                }
                if(j == N-1){
                    if(current>=2){
                        cnt2++;
                    }
                }
            }
        }

        System.out.println(cnt1+" "+ cnt2);
    }

}
