package khatabook;

import java.time.LocalDate;
import java.time.LocalTime;

public class Stock {

    LocalDate date;
    LocalTime time;
    int quantity;
    double price;
    double profit;

    public Stock(LocalDate date, LocalTime time, int quantity, double price, double profit) {
        this.date = date;
        this.time = time;
        this.quantity = quantity;
        this.price = price;
        this.profit = profit;
    }

    public Stock() {

    }

}
