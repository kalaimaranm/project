/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practise;

/**
 *
 * @author bas200193
 */
public class Main {

    public static void pratheeban(String[] args) {
        String s = "james created java";
        for (int i = s.length() - 5; i >= 0; i = i - 5) {
            if (Character.isAlphabetic(s.charAt(i))) {
                System.out.println(s.charAt(i));
            }
        }
//        System.out.println("forward");
//        for(int i=4;i>=0;i=i+4){
//            System.out.println(s.charAt(i));
//        }
        int[] arr = {22, 23, 24, 25, 26};
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            while(temp>0){
                int tempp = temp%10;
                temp = temp/10;
                if(tempp%2!=0){
                    sum+=tempp;
                }
               // temp=temp/10;
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        
    }
    
}

//    public static void mainw(String[] args) {
//        String s = "james created java";
//       for(int i=4;i<=s.length();i=i+5){
//           System.out.println(s.charAt(i));
//       }
//       for(int i=s.length())
//    }
//}
