import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static Set<Integer> trues = new HashSet<>();
    static List<List<Integer>> parties = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < c; i++) {
            trues.add(Integer.parseInt(st.nextToken()));
        }
        
        // 파티 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }
        
        // 진실을 아는 사람이 더 이상 증가하지 않을 때까지 반복
        boolean changed = true;
        while (changed) {
            changed = false;
            for (List<Integer> party : parties) {
                boolean hasTruth = false;
                
                // 파티에 진실을 아는 사람이 있는지 확인
                for (int person : party) {
                    if (trues.contains(person)) {
                        hasTruth = true;
                        break;
                    }
                }
                
                // 진실을 아는 사람이 있다면 모든 참가자가 진실을 알게 됨
                if (hasTruth) {
                    for (int person : party) {
                        if (!trues.contains(person)) {
                            trues.add(person);
                            changed = true;
                        }
                    }
                }
            }
        }
        
        // 거짓말할 수 있는 파티 개수 세기
        int cnt = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (trues.contains(person)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) cnt++;
        }
        
        System.out.println(cnt);
    }
}
