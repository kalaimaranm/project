/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khatabook;

import java.time.LocalTime;
import java.util.Arrays;
import static khatabook.Orders.order;
import static khatabook.Product.product;
import static khatabook.KhataBook.cust;

/**
 *
 * @author bas200193
 */
public class Statistics {

    String name;
    int id;
    double totalAmountOrder;
    String phoneNo;
    Statistics[] stat = new Statistics[0];

    public Statistics(String name, int id, double totalAmountOrder, String phoneNo) {
        this.name = name;
        this.id = id;
        this.totalAmountOrder = totalAmountOrder;
        this.phoneNo = phoneNo;
    }

    Statistics() {

    }

    public void maximumOrderProduct() {
        int maximumQuantity = product[0].getQuantity();
        for (int i = 0; i < product.length; i++) {
            for (int j = i + 1; j < product.length; j++) {
                if (maximumQuantity > product[j].getQuantity()) {
                    maximumQuantity = maximumQuantity;
                } else {
                    maximumQuantity = product[j].getQuantity();
                }
            }
        }
        String productName = "";
        for (int ch = 0; ch < product.length; ch++) {
            if (maximumQuantity == product[ch].getQuantity()) {
                productName = product[ch].getName();
                break;
            }
        }
        System.out.println("Maximum Order Product is " + productName);
    }

    public void minimumOrderProduct() {
        int minimumQuantity = product[0].getQuantity();
        for (int i = 0; i < product.length; i++) {
            for (int j = i + 1; j < product.length; j++) {
                if (minimumQuantity < product[j].getQuantity()) {
                    minimumQuantity = minimumQuantity;
                } else {
                    minimumQuantity = product[j].getQuantity();
                }
            }
        }
        String productName = "";
        for (int ch = 0; ch < product.length; ch++) {
            if (minimumQuantity == product[ch].getQuantity()) {
                productName = product[ch].getName();
                break;
            }
        }
        System.out.println("Minimum Order Product is " + productName);
    }

    public void minimumMarginProduct() {
        int index = 0;
        String productName = "";
        double minimum = product[0].getPrice();   // low price
        int quantity = product[0].getQuantity();// high quantity
        String[] miniMargin = new String[0];
        for (int i = 0; i < product.length; i++) {
            for (int j = i + 1; j < product.length; j++) {
                if (minimum > product[j].getPrice() && quantity > product[j].getPrice()) {
                    minimum = minimum;
                    quantity = quantity;
                    productName = productName;
                } else {
                    minimum = product[j].getPrice();
                    quantity = product[j].getQuantity();
                    productName = product[j].getName();
                }
            }
        }
        System.out.println("Minimum Margin Product is " + productName);
    }

    public void maximumMarginProduct() {
        int index = 0;
        String productName = "";
        double maximum = product[0].getPrice();   // low price
        int quantity = product[0].getQuantity();// high quantity
        String[] miniMargin = new String[0];
        for (int i = 0; i < product.length; i++) {
            for (int j = i + 1; j < product.length; j++) {
                if (maximum > product[j].getPrice() && quantity < product[j].getPrice()) {
                    maximum = maximum;
                    quantity = quantity;
                    productName = productName;
                } else {
                    maximum = product[j].getPrice();
                    quantity = product[j].getQuantity();
                    productName = product[j].getName();
                }
            }
        }
        System.out.println("Maximum Margin Product is " + productName);
    }

    public void profitOrder() {  // list by high amount orders - amount

    }

    public void peakHourInDay() {
        int morning = 0;
        int afternoon = 0;
        int evening = 0;
        for (int i = 0; i < order.length; i++) {
            int time = order[i].getTime().getHour();
//            if(time){
//                
//            }
        }

    }

    public void peakSaleHourInDay() {

    }

    public void customerRank() {
        for (int i = 0; i < cust.length; i++) {
            int cus = cust[i].custId;
            int sum = 0;
            for (int j = 0; j < order.length; j++) {
                if (order[j].getCusId() == cus) {
                    sum += order[j].getTotalPrice();
                }
            }
            stat = Arrays.copyOf(stat, stat.length + 1);
            stat[stat.length - 1] = new Statistics(cust[i].name, cust[i].custId, sum, cust[i].phoneNo);
        }
        //Arrays.sort(stat);
        System.out.println(Arrays.toString(stat));
    }
}
