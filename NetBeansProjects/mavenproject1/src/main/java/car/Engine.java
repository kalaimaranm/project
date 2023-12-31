package car;

import java.io.Serializable;

/**
 *
 * @author bas200193
 */
public class Engine implements Serializable{

    @Override
    public String toString() {
        return "Engine{" + "brand=" + brand + ", type=" + type + ", price=" + price + '}';
    }

    private String brand;
    private String type;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Engine(String brand, String type, double price) {
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

}
