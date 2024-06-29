

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] amount = new double[20];
        double[] grade = new double[20];
        int count = 0;

        for (int i = 0; i < 20; i++) {
            if (!sc.hasNextLine()) {
                break;
            }

            String s = sc.nextLine();
            String[] split = s.split(" ");

            if (split[2].equals("A+")) {
                grade[count] = 4.5;
            } else if (split[2].equals("A0")) {
                grade[count] = 4.0;
            } else if (split[2].equals("B+")) {
                grade[count] = 3.5;
            } else if (split[2].equals("B0")) {
                grade[count] = 3.0;
            } else if (split[2].equals("C+")) {
                grade[count] = 2.5;
            } else if (split[2].equals("C0")) {
                grade[count] = 2.0;
            } else if (split[2].equals("D+")) {
                grade[count] = 1.5;
            } else if (split[2].equals("D0")) {
                grade[count] = 1.0;
            } else if (split[2].equals("P")) {
                continue; // "P" 과목은 계산에서 제외
            } else {
                grade[count] = 0.0;
            }

            amount[count] = Double.parseDouble(split[1]);
            count++;
        }

        double result = 0;
        double sum = 0;
        for(int i=0; i<20; i++){
            result += amount[i] * grade[i];
            sum += amount[i];
        }
        if(sum!=0){
            System.out.printf("%.6f%n", result / sum);
        } else{
            System.out.println("0.000000");
        }
    }

}
