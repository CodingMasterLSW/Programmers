import java.util.*;

class Solution {
    static List<Direction> phone = new ArrayList<>();
    
    static Direction currentLeftDirection;
    static Direction currentRightDirection;
    
    public String solution(int[] numbers, String hand) {
        init();
        
        currentLeftDirection = phone.get(10);
        currentRightDirection = phone.get(11);   
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numbers.length; i++) {
            sb.append(calculate(numbers[i], hand));
        }
        return sb.toString();
    }
    
    public static String calculate(int number, String hand) {
        if (number == 1 || number == 4 || number == 7) {
            currentLeftDirection = phone.get(number);
            return "L";
        }
        
        if (number == 3 || number == 6 || number == 9) {
            currentRightDirection = phone.get(number);
            return "R";
        }
        
        Direction targetDirection = phone.get(number);
        
        int leftResult = Math.abs(targetDirection.getX() - currentLeftDirection.getX()) + Math.abs(targetDirection.getY() - currentLeftDirection.getY());
        
        int rightResult = Math.abs(targetDirection.getX() - currentRightDirection.getX()) + Math.abs(targetDirection.getY() - currentRightDirection.getY());
        
        if (leftResult == rightResult) {
            if (hand.equals("right")) {
                currentRightDirection = phone.get(number);
            } else {
                currentLeftDirection = phone.get(number);
            }
            return String.valueOf(hand.toUpperCase().charAt(0));
        }
        
        if (leftResult > rightResult) {
            currentRightDirection = phone.get(number);
            return "R";
        } else {
            currentLeftDirection = phone.get(number);
            return "L";
        }
    }
    
    public static void init() {
        phone.add(new Direction(3, 1));
        
        phone.add(new Direction(0, 0));
        phone.add(new Direction(0, 1));
        phone.add(new Direction(0, 2));
        
        phone.add(new Direction(1, 0));
        phone.add(new Direction(1, 1));
        phone.add(new Direction(1, 2));
        
        phone.add(new Direction(2, 0));
        phone.add(new Direction(2, 1));
        phone.add(new Direction(2, 2));
        
        phone.add(new Direction(3, 0));
        phone.add(new Direction(3, 2));
    }
}

class Direction {
    int x;
    int y;
    
    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}