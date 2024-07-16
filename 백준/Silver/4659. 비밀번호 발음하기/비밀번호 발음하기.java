import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String next = sc.next();
            if(next.equals("end")){
                break;
            }

            if (check(next)) {
                System.out.println("<" + next + ">" + " is acceptable.");
            } else {
                System.out.println("<" + next + ">" + " is not acceptable.");
            }
        }
    }

    private static boolean check(String next) {

        if(next.length()<=1){
            if(!next.equals("a") && !next.equals("e") && !next.equals("i") && !next.equals("o") && !next.equals("u")) {
                return false;
            }
            return true;
        }

        int vow = 0;
        int con = 0;
        int consequenceVow = 0;
        int consequenceCon = 0;
        char[] array = next.toCharArray();

        for (int i = 0; i < array.length; i++) {

            if (array[i] != 'a' && array[i] != 'e' && array[i] != 'i' && array[i] != 'o'
                    && array[i] != 'u') {
                con++;
                consequenceCon++;
                consequenceVow = 0;
                if (consequenceCon >= 3) {
                    return false;
                }
            } else {
                vow++;
                consequenceVow++;
                consequenceCon = 0;
                if (consequenceVow >= 3) {
                    return false;
                }

            }

            if(i==array.length-1){
                continue;
            } else {
                if (array[i] == array[i + 1]) {
                    if (array[i] == 'e' || array[i] == 'o') {
                        continue;
                    }
                    return false;
                }

            }
        }
        if(vow == 0){
            return false;
        }
        if(array[array.length-1] == array[array.length-2]){
            if(array[array.length-1] == 'e' || array[array.length-1] == 'o'){
                return true;
            }
            return false;
        }

        return true;
    }

}
