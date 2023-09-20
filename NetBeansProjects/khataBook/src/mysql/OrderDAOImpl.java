package mysql;

import dao.OrdersDAO;

public class OrderDAOImpl implements OrdersDAO {

    @Override
    public int genOrderID() {
        return 0;
    }

    @Override
    public boolean orderEntry(model.Order order) {
        return false;
    }

    @Override
    public void placeOrder() {

    }

}
