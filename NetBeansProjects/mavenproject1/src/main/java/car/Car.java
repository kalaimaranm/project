package car;

import java.beans.Transient;
import java.io.Serializable;

/**
 *
 * @author bas200193
 */
public class Car implements Serializable {

    @Override
    public String toString() {
        return "Car{" + "model=" + model + ", price=" + price + ", colour=" + colour + ", engine=" + engine + '}';
    }

    Car() {

    }

    private String model;
    private double price;
    transient private String colour;
    private Engine engine;

    public Car(String model, double price, String colour, Engine engine) {
        this.model = model;
        this.price = price;
        this.colour = colour;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public String getColour() {
//        return colour;
//    }
//
//    public void setColour(String colour) {
//        this.colour = colour;
//    }
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
