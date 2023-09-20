package ReadyToUse;

import java.util.Scanner;

public class Regex {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter Your name ");
        String name = scan.next();
        System.out.println("Plese Enter password ");
        String password = scan.next();
        String rex = "[a-zA-Z0-9]+[^a-zA-Z0-9]+{8,20}";
        while (!(name.matches(rex))) {
            System.out.println("password matches successfully...");
//        } else {
//            System.out.println("Given password is not in proper Format");
//        }
        }
    }
}
