package se.design_philosophy.dgp;

public class OnlinePay {
    private IPaymentInterface payment;
    public OnlinePay(IPaymentInterface payment) {
        this.payment = payment;
    }
    public void makePayment(double amount) {
        payment.pay(amount);
    }
}
