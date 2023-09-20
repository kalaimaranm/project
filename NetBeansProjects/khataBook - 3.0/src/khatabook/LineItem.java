
package khatabook;

import static khatabook.Product.product;

//or
public class LineItem {
        
    private int quantity;
    private String productName;
    private int productId;
    private double itemAmount;
    private short sNo;
    public LineItem(short sNo,int quantity, String productName, int productId, double itemAmount) {
        this.sNo = sNo;
        this.quantity = quantity;
        this.productName = productName;
        this.productId = productId;
        this.itemAmount = itemAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public short getsNo() {
        return sNo;
    }

    public void setsNo(short sNo) {
        this.sNo = sNo;
    }
    LineItem(){
        
    }

    @Override
    public String toString() {
        double price=0;
        for(int i=0;i<product.length;i++){
            if(productId==product[i].getId()){
                price=product[i].getPrice();
                break;
            }
        }
        System.out.format("\n|%-4d|%-18s|%-10.2f|%-9d|%-10.2f",this.sNo,this.productName,price,this.quantity,this.quantity*price);
        return "";
    }
   
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getItemAmount() {
        return itemAmount;
    }
}
