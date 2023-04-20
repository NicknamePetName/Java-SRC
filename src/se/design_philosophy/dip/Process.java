package se.design_philosophy.dip;

public class Process {
    public static void main(String[] args) {
        IPaymentInterface aliPay = new AliPay();
        IPaymentInterface wechatPay = new WechatPay();
        OnlinePay onlinePay = new OnlinePay(aliPay);
        onlinePay.makePayment(1000); // Using AliPay to pay 1000.0 RMB.
        onlinePay = new OnlinePay(wechatPay);
        onlinePay.makePayment(2000); // Using WechatPay to pay 2000.0 RMB.
    }
}
