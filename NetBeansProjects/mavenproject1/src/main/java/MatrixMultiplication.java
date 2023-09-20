
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows you want m1");
        int row1 = scan.nextInt();
        System.out.println("Enter the number of column you want m1");
        int column1 = scan.nextInt();
        int[][] m1 = new int[row1][column1];
         System.out.println("Enter the number of rows you want m2");
        int row2 = scan.nextInt();
        System.out.println("Enter the number of column you want m2");
        int column2 = scan.nextInt();
        int[][] m2 = new int[row2][column2];
        int [][] m1m2 = new int[row1][column2];
        int a = row1;
        int b= column1;
        int x = row2;
        int y= column2;

        System.out.println("Enter the values for m1 ");
        for(int in=0;in<m1.length;in++){
            for(int inn=0;inn<m1[in].length;inn++){
            m1[in][inn] = scan.nextInt();
            }
        }
        System.out.println("Enter the values for m2 ");
        for(int in=0;in<m2.length;in++){
            for(int inn=0;inn<m2[in].length;inn++){
            m2[in][inn] = scan.nextInt();
            }
        }
        int sum = 0;
        if(b==x){
        for(int i=0;i<row1;i++){
            for(int j=0;j<column2;j++){
                for(int k=0;k<row2;k++){
                   sum = sum + m1[i][k]*m2[k][j]; 
                }
                m1m2[i][j]=sum;
                sum=0;
            }
        }
        }
        else{
            System.out.println("Please enter a valid rows and column");
        }
for(int[] temp:m1m2){
    for(int i=0;i<temp.length;i++){
        System.out.print(" "+temp[i]);
    }
    System.out.println("");
}        
    }
}
// int a = row1 int b = column1 int x=row2 int y= column2 b==3 to multiply    a row and y is column for multipled value storage