import java.util.*;

class Solution {
    
    static char[][] phone = new char[4][3];
    static boolean[][] visited = new boolean[4][3];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[] currentLeftHand = new int[]{3, 0};
    static int[] currentRightHand = new int[]{3, 2};

    public String solution(int[] numbers, String hand) {
        initPhone();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numbers.length; i++) {
            // System.out.println(
            //     "왼손 위치: " + phone[currentLeftHand[0]][currentLeftHand[1]]
            // );
            // System.out.println(
            //     "오른손 위치: " + phone[currentRightHand[0]][currentRightHand[1]]
            // );
            // System.out.println();
            sb.append(calculate(numbers[i], hand));
        }
        return sb.toString();
    }
    
    public static String calculate(int number, String hand) {
        if (number == 1 || number == 4 || number == 7) {
            updateHand(number, "left");
            return "L";
        }
        if (number == 3 || number == 6 || number == 9) {
            updateHand(number, "right");
            return "R";
        }
        visited = new boolean[4][3];
        int distance1 = bfs(number, currentLeftHand);
        //System.out.println("왼손 거리 : " + distance1);
        
        visited = new boolean[4][3];
        int distance2 = bfs(number, currentRightHand);
        //System.out.println("오른손 거리 : " + distance2);
        
        if (distance1 == distance2) {
            updateHand(number, hand);
            return String.valueOf(Character.toUpperCase(hand.charAt(0)));
        }
        
        if (distance1 < distance2) {
            updateHand(number, "left");
            return "L";
        }
        updateHand(number, "right");
        return "R";
    }
    
    public static int bfs(int target, int[] start) {
        //System.out.println("bfs 시작");
        //System.out.println("시작 좌표 : " + start[0] + " " + start[1]);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 0});
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            
            if (phone[current[0]][current[1]] == (char)(target + '0')) {
                return current[2];
            }
            
            for (int i=0; i<4; i++) {
                int ndx = current[0] + dx[i];
                int ndy = current[1] + dy[i];
                
                if (ndx < 0 || ndx > 3 || ndy < 0 || ndy > 2) {
                    continue;
                }
                
                if (visited[ndx][ndy]) {
                    continue;
                }
                visited[ndx][ndy] = true;
                q.offer(new int[]{ndx, ndy, current[2] + 1});
            }
        }
        return -1;
    }
    
    public static void updateHand(int number, String hand) {
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 3; j++) {
            if (phone[i][j] == (char)(number + '0')) {
                if (hand.equals("right")) {
                    currentRightHand = new int[]{i, j};
                } else {
                    currentLeftHand = new int[]{i, j};
                }
                return;
            }
        }
    }
}

    
    public static void initPhone() {
        phone[0][0] = '1';
        phone[0][1] = '2';
        phone[0][2] = '3';
        phone[1][0] = '4';
        phone[1][1] = '5';
        phone[1][2] = '6';
        phone[2][0] = '7';
        phone[2][1] = '8';
        phone[2][2] = '9';
        phone[3][0] = '*';
        phone[3][1] = '0';
        phone[3][2] = '#';
    }
}