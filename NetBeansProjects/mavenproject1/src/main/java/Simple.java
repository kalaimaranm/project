/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class Simple  {
           static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select the Calculator from the below options");
        System.out.println("Press 1 : Simple Calculator\n Press 2 : Scientific Calculator\n Press 3 : Business Calculator \n Press 4 : Financial Calculator");
        System.out.println("Press 5 : Exit");
        int select = scan.nextInt();
        boolean flag = true;
        while(flag){
        switch(select){
            case 1 : {
                System.out.println("Simple Calculator");
                break;
            }
            case 2 : {
                System.out.println("Scientific Calculator");
                break;
            }
            case 3 : {
                System.out.println("Business Calculator");
                 System.out.println("-------------------------------------------------------------------------");
            System.out.println("Enter The Principal Amount");
            double principal=scan.nextDouble();
            System.out.println("Enter The No Of Years");
            double noOfYears=scan.nextDouble();
            System.out.println("Enter The Rate Of Intrest");
            double interest=scan.nextDouble();
                System.out.println("Press 1 : simpleInterest");
                System.out.println("Press 2 : compoundInterest");
                int selectt = scan.nextInt();
                Sample s = new Sample(interest,noOfYears,principal);
                switch(selectt){
                    case 1:{
                        System.out.println("SimpleInterest");
                        System.out.println(s.simpleInterest());
                        System.out.println(s);
                        break;
                    }
                    case 2:{
                        System.out.println("CompundInterest");
                        System.out.println(s.compoundInterest());
                        System.out.println(s);
                        break;
                    }
                }           
                break;
            }
            case 4 : {
                System.out.println("Financial Calculator");
                
                
                break;
            }

            case 5 :{
                flag = false;
                break;
            }
            default :{
                  System.out.println("Please select a valid options"); 
               }
        }
        }
    }
}
class Sample extends Scientific{
    
     Sample(double interest, double noOfYear, double principleAmount) {
        super(interest, noOfYear, principleAmount);
    }
    
}
class Scientific extends Business {
    
     Scientific(double interest, double noOfYear, double principleAmount) {
        super(interest, noOfYear, principleAmount);
    }
    
}
class Business{
    double interest;
    double noOfYears;
    double principleAmount;
    double totalAmount;
    Business(double interest, double noOfYear, double principleAmount){
        this.interest = interest;
        this.noOfYears = noOfYear;
        this.principleAmount = principleAmount;
    }
    public double simpleInterest(){
        totalAmount = (this.principleAmount+(this.principleAmount*this.noOfYears*this.interest)/100);
        return totalAmount;
    }
    public double compoundInterest(){
        totalAmount = (this.principleAmount*Math.pow((this.interest/(100*12)+1),(this.noOfYears*12)));
        return totalAmount;
    }
    public String toString(){
        return "You Payable TotalAmount is Rs."+this.totalAmount+ "for year Compounded annually Rs."+this.noOfYears+"@ an interest rate of "+this.interest+"for the principal Amount "+this.principleAmount;
    }
}