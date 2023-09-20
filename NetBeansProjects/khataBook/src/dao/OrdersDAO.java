package dao;

public interface OrdersDAO {

    public int genOrderID();

    public boolean orderEntry(model.Order order);

    public void placeOrder();
}
