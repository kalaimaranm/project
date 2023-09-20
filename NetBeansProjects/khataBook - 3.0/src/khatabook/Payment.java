package khatabook;

public class Payment {

    private String phoneNo;
    private String paymentModeOnline;
    private double paidAmount;
    private double debt;

    public Payment(String phoneNo, String paymentModeOnline, double paidAmount, double debt) {
        this.phoneNo = phoneNo;
        this.paymentModeOnline = paymentModeOnline;
        this.paidAmount = paidAmount;
        this.debt = debt;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPaymentModeOnline() {
        return paymentModeOnline;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDebt() {
        return debt;
    }

    public void setPaymentModeOnline(String paymentModeOnline) {
        this.paymentModeOnline = paymentModeOnline;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

}
