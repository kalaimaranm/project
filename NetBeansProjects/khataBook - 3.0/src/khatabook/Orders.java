
package khatabook;

import java.time.LocalDate;
import static khatabook.Customer.j;
import java.time.LocalTime;
import static khatabook.KhataBook.cust;

public class Orders {

    private int orderid;
    private int cusId;
    private String cusPhone;
    private double totalPrice;
    private LocalDate date;
    private LocalTime time;
    LineItem[] lineItem = new LineItem[0];
    static Orders order[] = new Orders[0];


    public Orders(LocalDate date,LocalTime time,int orderid, int cusId, String cusPhone, double totalPrice, LineItem[] lineItem) {
        this.time = time;
        this.date = date;
        this.orderid = orderid;
        this.cusId = cusId;
        this.cusPhone = cusPhone;
        this.totalPrice = totalPrice;
        this.lineItem = lineItem.clone();
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderid=" + orderid + ", cusId=" + cusId + ", totalPrice=" + totalPrice + '}';
    }

    Orders() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
