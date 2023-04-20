package se.design_philosophy.dip;

public class OnlinePay {
    private IPaymentInterface payment;
    public OnlinePay(IPaymentInterface payment) {
        this.payment = payment;
    }
    public void makePayment(double amount) {
        payment.pay(amount);
    }
}
