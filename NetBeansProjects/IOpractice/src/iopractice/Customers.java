
package iopractice;


public class Customers {
    int id;
    String name;
    String address;
    String phoneNo;
    public Customers[] customer = new Customers[5];
    int index=0;
    int idInc=1000;
    public Customers(){}

    public Customers(int id, String name, String address, String phoneNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }
//    {
//        customer[index]=new Customers(idInc,"kalaimaran","Thiruvarur","8610825343");
//        customer[++index]=new Customers(++idInc,"Harish","Kumbakonam","9087962506");
//        customer[++index]=new Customers(++idInc,"Natraj","Viruthachallem","1234567899");
//        customer[++index]=new Customers(++idInc,"Vengat","Chitambaram","0987654321");
//        customer[++index]=new Customers(++idInc,"Dinakaran","Chennai","9999999999");
//    }
//    
    
}
