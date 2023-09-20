/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bas200193
 */
public class Logical {

    public static void main1(String[] args) {
        int[] arr = {1, 12, 3, 15};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 9) {
                int temp = arr[i];
                while (temp > 0) {
                    sum = sum + arr[i] % 10;
                    temp = arr[i] / 10;

                }

            } else {
                sum = sum + arr[i];
            }
        }
        System.out.println(sum);
    }

    public static void thirdCharacter(String[] args) {
        String s = "kalaimaran";   // l,m,a
        for (int i = 3; i < s.length(); i++) {
            if (i % 3 == 0) {
                System.out.println(s.charAt(i - 1));
            }
        }
        for (int i = 3; i < s.length(); i = i + 3) {
            System.out.println(s.charAt(i - 1));
        }

    }

    public static void sum(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    public static void min(String[] args) {
        int[] arr = {98, 74, 99, 10, 9, 2};
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }

    public static void max(String[] args) {
        int[] arr = {98, 74, 99, 10, 9, 2};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void sortMin(String[] args) {
        int[] arr = {98, 74, 99, 10, 9, 2};
        for (int i = 0; i < arr.length; i++) {

        }

    }

    public static void palindrome(String[] args) {
        String name = "kalaimaran";
        String rev = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            rev += name.charAt(i);
        }
        System.out.println(rev);
    }

    public static void countNumberOfWords(String[] args) {
        int num = 1343;
        String s = num + "";
        System.out.println(s.length());
        int temp = num;
        int count = 0;
        while (temp > 0) {
            temp = temp / 10;
            count++;
        }
        System.out.println(count);

    }

    public static void sumOfNumber(String[] args) {
        int num = 8383;
        int temp = num;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        System.out.println(sum);
    }

    public static void evenToAdd(String[] args) {
        int[] num = {2, 4, 5, 9};
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.println(++num[i]);
            }
        }

    }

    public static void onlySpecifiedCharacter(String[] args) {
        String name = "kalaimajkasdfu092385723$%^&*jasdf  ''\"\\ran.m";
        String nameConversion = name.replaceAll("[^a-zA-Z]", "");
        System.out.println(nameConversion);
        int[] arr = {1, 2, 94, 13, 3};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int s = arr[i];
//            if(s.length()>=2){
//                for(int j=0;j<s.length();j++){
//                    sum+=Character.getNumericValue(s.charAt(j));
//                }
//            }
//            else{
//                sum+=arr[i];
//            }

            while (s > 0) {
                sum += s % 10;
                s = s / 10;
            }

        }

        System.out.println(sum);
    }

    public static void wait(String[] args) {
        String name = "arun kumar";
//        for(int i=0;i<name.length();i++){
//            int count =1;
//            for(int j=i+1;j<name.length();j++){
//                if(name.charAt(i)!=name.charAt(j)){
//                    count++;
//                }
//            }
//            if(count>1){
//                System.out.println("Duplicate is "+name.charAt(i) + " times "+ count);
//            }
////            if(count==1){
////                System.out.println("Non Duplicate Values are "+ name.charAt(i));
//            }
//        }
        for (int i = 0; i < name.length(); i++) {

        }
    }

    public static void ascSorting(String[] args) { //>  ending
        int[] arr = {90, 12, 85, 3, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void desSorting(String[] args) { //<  ending
        int[] arr = {90, 12, 85, 3, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void printThirdCharacter(String[] args) {
        String sen = "Hai Hello I am Kalaimaran";
        String[] senArr = sen.split(" ");
        for (int i = 0; i < senArr.length; i++) {
            if (senArr[i].length() >= 3) {
                System.out.println(senArr[i].charAt(2));
            }
        }
    }

    public static void factorialNumber(String[] args) {
        String s = "Iam_";
        int num = 5;
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void primeNumber(String[] args) {
        int f = 10;
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            if (f % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("prime number");
        } else {
            System.out.println("not prime number");
        }
    }

    public static void splitEachWord(String[] args) {
        String s = "james created java";
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            System.out.println(temp.charAt(2));
        }
    }

    public static void onlySpecifiedCharacter2(String[] args) {
        String s = "ja2es cr*atEd _Jav%a";
        String reg = "[a-zA-Z]";//[^a-z]
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            if (c.matches(reg)) {
                System.out.print(c);
            }
        }

    }

    public static void firstLastThirdChar(String[] args) {
        String s = "james created j-va";
        String[] split = s.split(" ");

//        for(int i=0;i<split.length;i++){
//            System.out.println(split[i].charAt(split[i].length()-3));
//        }
        for (int j = s.length() - 3; j >= 0; j = j - 3) {
            if (Character.isAlphabetic(s.charAt(j))) {
                System.out.println(s.charAt(j));
            }

        }
        String n = "123123123123123";
        for (int i = 3; i < n.length(); i = i + 3) {
            System.out.println(n.charAt(i - 1));
        }
        String reg = "[0-9]";
        for (int i = n.length() - 3; i >= 0; i = i - 3) {
            String temp = n.charAt(i) + "";
            if (temp.matches(reg)) {
                System.out.println(n.charAt(i));
            }
        }
    }

    public static void mains(String[] args) {
        String s = "I am Kalaimaran Thank you";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 1;
//            if()
        }
    }

    public static void reg(String[] args) {
        String phone = "123-123*123";
        String rex = "\\d{3}[^a-bA-Z0-9]\\d{3}[^a-bA-Z0-9]\\d{3}";
        String email = "kalaimaran123@gmail.com";
        String redEmail = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]+";
        System.out.println(email.matches(redEmail) + " emailValidation");
        if (phone.matches(rex)) {
            System.out.println("phone number is in right format");
        } else {
            System.out.println("phone number is in wrong format");
        }
        int sum = 0;
        int[] arr = {123, 213, 123, 432};
//         int temp = arr[0]/10;
//         System.out.println(temp%10);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1000) {
                int temp = arr[i] / 10;
                int centre = temp % 10;
                if (centre % 2 != 0) {
                    sum += centre;
                }
            }
        }
        System.out.println(sum);
    }

    public static void mainw(String[] args) {
        String s = "^[a-z]$+";   // * - 0-1
        // +
        String ss = "[a-z]";
        System.out.println("9a".matches(ss));
        int num = 3;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static void countSecondIntFromLast(String[] args) {
        int[] arr = {123, 3098, 3343, 34343};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] % 100;
            int sep = temp / 10;
            sum += sep;
        }
        int summ = 0;
        System.out.println(sum);
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i] + "";
            int len = s.length() - 2;
            summ = summ + Integer.parseInt(s.charAt(len) + "");
        }
        System.out.println(summ);
    }

    public static void maximumInEachIndex(String[] args) {
//        for(int i=5;i<s.length();i=i+5){
//            System.out.println(s.charAt(i-1));
//        }
        int[] arr = {134, 111, 3984, 34839};
        for (int i = 0; i < arr.length; i++) {
            int sep = arr[i];
            int max = 0;
            while (sep > 0) {
                int temp = sep % 10;
                sep = sep / 10;
                if (temp > max) {
                    max = temp;
                }
            }
            System.out.println("Maximum value in " + i + " is " + max);
        }
//        for (int i = 0; i < arr.length; i++) {
//            int sep = arr[i];
//            int max = 0;
//            int temp = 0;
//            while (sep > 0) {
//                temp = sep % 10;
//                sep = sep / 10;
//                if (temp > max) {
//                    max = temp;
//                }
//            }
//            System.out.println("maximum value in " + i + " index " + max);
//        }
        String s = "No comment simply waste";
        for (int ss = s.length() - 5; ss >= 0; ss = ss - 5) {
            System.out.println(s.charAt(ss));
        }
    }

    public static void mainww(String[] args) {
        String[] a = {"aruN", "balA", "kalzi"};
//        for (int i = 0; i < a.length; i++) {
//    if(a[i].charAt(a[i].length()-1)>=65 && a[i].charAt(a[i].length()-1)<=90){
//        System.out.println(a[i]);
//    }
//        }
        String s = "[a-bA-Z]";
        for (int i = 0; i < a.length; i++) {
            String sep = a[i];
            for (int j = 0; j < sep.length(); j++) {
                if ((sep.charAt(j) + "").matches(s)) {
                    System.out.print(sep.charAt(j));
                }
            }
            System.out.println("");

        }
        String con = "I am Dinakaran from Chennai";
//    for(int i=s.length()-2;i>=0;i=i-2){
//        System.out.println(s.charAt(i));
//    }
//        String sene = "This is my paragraph";
//        char[] c = sene.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            char sep = c[i];
//            int count = 1;
//            for (int j = i + 1; j < c.length; j++) {
//                if (c[j] != ' ' && c[j] == sep) {
//                    count++;
//                    c[j] = ' ';
//                }
//            }
//            if (c[i] != ' ') {
//                System.out.println(sep + "repeated " + count + " times");
//            }
//        }
        char[] c = con.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 65 && c[i] <= 90) {
                int plus = c[i] + 32;
                System.out.println(plus);
                c[i] = (char) plus;
            }
        }
        //System.out.println(Arrays.toString(c));
        char[] cc = con.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            if ((int) (cc[i]) >= 65 && (int) (cc[i]) <= 90) {
                cc[i] = (char) ((int) cc[i] + 32);
            }
        }
        System.out.println(Arrays.toString(cc));
        char[] capToSmall = con.toCharArray();
        for (int i = 0; i < capToSmall.length; i++) {
            if ((int) capToSmall[i] >= 97 && (int) capToSmall[i] <= 122) {
                capToSmall[i] = (char) ((int) capToSmall[i] - 32);
            }
        }
        System.out.println(Arrays.toString(capToSmall));
    }

    public static void centerSum(String[] args) {
//    String number = "8610825343";
//   String reg = "[6-9][0-9]{8}[1-9]";
//   String userId = "Kalaimaran";
//   String userIdreg = "[a-zA-Z]{1,25}[]";    // length - [*+?] is for how many times a character can exist != this is for length{1,8},{0,1}.....  
//   String email = "kalaimaran123@gmail.com";
//        String redEmail = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]+";
//        System.out.println(email.matches(redEmail) + " emailValidation");
//   if(number.matches(reg)){
//       System.out.println("Phone Number in Proper Format");
//   }
//   else{
//       System.out.println("Phone Number Not in proper Format");
//   
        int[] arr = {123, 15152, 676, 74, 982378};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i] + "";
            if (Integer.parseInt(s) > 0) {
                int centre = s.length() / 2;
                sum = sum + Integer.parseInt(s.charAt(centre) + "");
            }

        }
        System.out.println(sum);
        //System.out.println(Math.abs(5/2)+1);
    }

    public static void reverseEvenWord(String[] args) {
        String sen = "Hai I am Kalaimaran from Kumbakonam";
        String[] senSplit = sen.split(" ");
        for (int i = 0; i < senSplit.length; i++) {
           String first = senSplit[i];
           if((i+1)%2==0){
               String rev="";
               for(int j=first.length()-1;j>=0;j--){
                   rev=rev+first.charAt(j);
               }
               senSplit[i]=rev;
           }
        }
        System.out.println(Arrays.toString(senSplit));
    }
    public static void main(String[] args) {
       try {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
       }
       catch(Exception e){
           System.out.println(e.getMessage());           
       }
       
        
    }

}
