/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class MatrixTranspose {
    public static void main(String[] args) {
        
      //  int[][] m1 = {{1,2,3},{1,2,3},{1,2,3}};
        //int[][] m2 = {{4,5,6},{4,5,6},{4,5,6}};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows you want ");
        int row = scan.nextInt();
        System.out.println("Enter the number of column you want ");
        int column = scan.nextInt();
        int[][] m1 = new int[row][column];
       

        System.out.println("Enter the values for m1 ");
        for(int in=0;in<m1.length;in++){
            for(int inn=0;inn<m1[in].length;inn++){
            m1[in][inn] = scan.nextInt();
            }
        }
       // for()
        int[][] m1T = new int[column][row];
        
        
        
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[i].length;j++){
                m1T[j][i] = m1[i][j];
            }
        }
        for(int[] temp:m1T){
            for(int tem:temp){
                System.out.print(" "+tem);
            }
            System.out.println("");
        }
        
    }
    
}
