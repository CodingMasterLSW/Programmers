import java.io.*;
import java.util.*;

class Main {

    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            graph = new char[3][3];

            char[] chars = s.toCharArray();
            int idx = 0;

            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    graph[i][j] = chars[idx];
                    idx++;
                }
            }

            // for (int i=0; i<3; i++) {
            //     for (int j=0; j<3; j++) {
            //         System.out.print(graph[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            if (validate()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    public static boolean validate() {
        int cntX = 0;
        int cntO = 0;
        int cntBlank = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (graph[i][j] == 'X') {
                    cntX++;
                } else if (graph[i][j] == 'O') {
                    cntO++;
                } else {
                    cntBlank++;
                }
            }
        }

        if (cntX < cntO) {
            return false;
        }

        if (cntX - cntO > 1) {
            return false;
        }

        if (isBingoX() && isBingoO()) {
            return false;
        }

        if (isBingoX() && cntX - cntO == 1) {
            return true;
        }

        if (isBingoO() && cntX - cntO == 0) {
            return true;
        }

        if (!isBingoO() && !isBingoX() && cntBlank == 0) {
            return true;
        }
        
        return false;
    }

    public static boolean isBingoX() {
        for (int i=0; i<3; i++) {
            boolean flag = true;
            for (int j=0; j<3; j++) {
                if (graph[i][j] != 'X') {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }

        for (int i=0; i<3; i++) {
            boolean flag = true;
            for (int j=0; j<3; j++) {
                if (graph[j][i] != 'X') {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }

        if (graph[0][0] == 'X' && graph[1][1] == 'X' && graph[2][2] == 'X') {
            return true;
        }

        if (graph[0][2] == 'X' && graph[1][1] == 'X' && graph[2][0] == 'X') {
            return true;
        }

        return false;
    }

    public static boolean isBingoO() {
        // O 빙고 판별 로직
        for (int i=0; i<3; i++) {
            boolean flag = true;
            for (int j=0; j<3; j++) {
                if (graph[i][j] != 'O') {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }

        for (int i=0; i<3; i++) {
            boolean flag = true;
            for (int j=0; j<3; j++) {
                if (graph[j][i] != 'O') {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }

        if (graph[0][0] == 'O' && graph[1][1] == 'O' && graph[2][2] == 'O') {
            return true;
        }

        if (graph[0][2] == 'O' && graph[1][1] == 'O' && graph[2][0] == 'O') {
            return true;
        }

        return false;
    }

}