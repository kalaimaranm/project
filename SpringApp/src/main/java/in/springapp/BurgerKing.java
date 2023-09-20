package in.springapp;

import in.springapp.Hotel;

public class BurgerKing implements Hotel {

    private String item;
    private int price;

    @Override
    public String toString() {
        return "BurgerKing{" + "item=" + item + ", price=" + price + '}';
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BurgerKing(String item, int price) {
        this.item = item;
        this.price = price;
    }

    public String menu() {
        return "";
    }

    public boolean order() {
        return true;
    }
}
