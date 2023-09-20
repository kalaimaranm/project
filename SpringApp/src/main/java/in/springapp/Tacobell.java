package in.springapp;

public class Tacobell implements Hotel {

    private String address;
    private long price;
    
    public Tacobell(){}

    public Tacobell(String address, long price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tacobell{" + "address=" + address + ", price=" + price + '}';
    }

    public String menu() {

        return "1. Burrito  $169\n2. Classic Burrito  $199\n3. Grilled Burrito  $199\n4. Burrito with Fries  $249\n5. Burrito with Coke  $249";
    }

    public boolean order() {

        return true;
    }


}
