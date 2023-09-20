/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;

public class BubbleSort {

    public static void main(String args[]) {
        int arr[] = {5, 4, 3, 2, 1};//{5,4,3,2,1};
        BubbleSort bs = new BubbleSort();
        bs.InsertionSort();
        BubbleSort.selectionSort(arr);
        boolean swapped = false;   // if user gives sorted array then flag remains the same condition
        outer:
        for (int i = 0; i < arr.length; i++) {
            for (int j=1; j < arr.length-i; j++) {
                if (arr[j-1]>arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                    swapped = true;     // 
                }

            }
            if (swapped == false) {
                break outer;   //using  label is same as without label 
            }
        }
        /*for(int i=0;i<arr.length;i++){
          for(int j=1;j<arr.length-i;j++){
              if(arr[i]>arr[j]){
                  int temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
              }
          }
      
       }*/
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int getarr[]) {
       // int max = getarr[0];
       int len = getarr.length;
for(int io=0;io<getarr.length;io++){
        for (int i = 0;i< getarr.length-oi;i++) {
            int max = getarr[io];
            if (max<getarr[i+1]) {
                max = getarr[i+1];
            }
            else {
                max = getarr[io];
            }
             len = getarr.length;
            int temp= getarr[getarr.length-io];
            getarr[getarr.length-1] = max;
            getarr[i]=temp;
            
            
            }
--len;
}    


}
    public static void InsertionSort(){
        int arr[] = {5,4,3,2,1};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                int temp =0;
                if(arr[j]<arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println("Insertion sort is ");
        System.out.println(Arrays.toString(arr));
    }
    public static int[] swap(int[] garr, int garr[j],int garr[j-1]){
                       int temp =0;               
                       temp = garr[j];
                      garr[j] = garr[j-1];
                      garr[j-1] = temp;
                      return garr[];
}
}
