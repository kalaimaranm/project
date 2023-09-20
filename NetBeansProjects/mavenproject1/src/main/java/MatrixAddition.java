/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of row in m1 ");
        int row1 = scan.nextInt();
        System.out.println("Enter the number of columns in m1 ");
        int column1 = scan.nextInt();
        System.out.println("Enter the number of row in m2");
        int row2 = scan.nextInt();
        System.out.println("Enter the number of columns in m2 ");
        int column2 = scan.nextInt();
        int[][] m1 = new int[row1][column2];
        int [][] m2 = new int[row2][column2];
        int[][] m1m2 = new int[row1][column1];
        if(row1 == row2 && column1 == column2){
        System.out.println("Enter the values for m1 ");
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[i].length;j++){
                m1[i][j]=scan.nextInt();
            }
        }
        System.out.println("Enter the values for m2 ");
        for(int i=0;i<m2.length;i++){
            for(int j=0;j<m2[i].length;j++){
                m2[i][j]=scan.nextInt();
            }
        }
        
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[i].length;j++){
               m1m2[i][j] = m1[i][j]+m2[i][j]; 
            }
        }
        }
        else{
            System.out.println("Please enter a valid rows and column ");
        }
        for(int[] temp:m1m2){
            for(int i=0;i<temp.length;i++){
                System.out.print(" "+temp[i]);
            }
            System.out.println();
        }
    }
}
