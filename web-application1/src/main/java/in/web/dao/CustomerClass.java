package in.web.dao;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
public class CustomerClass {

    private int id;
    private String name;
    private String phone;
    private String aadhaar;
    private double debtBalance;
    private double walletBalance;
    private boolean status;

    public CustomerClass(int id, String name, String phone, String aadhaar, double debtBalance, double walletBalance, boolean status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.aadhaar = aadhaar;
        this.debtBalance = debtBalance;
        this.walletBalance = walletBalance;
        this.status = status;
    }


    public CustomerClass() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public double getDebtBalance() {
        return debtBalance;
    }

    public void setDebtBalance(double debtBalance) {
        this.debtBalance = debtBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
