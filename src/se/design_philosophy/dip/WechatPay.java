package se.design_philosophy.dip;

public class WechatPay implements IPaymentInterface {
    public void pay(double amount) {
        System.out.println("Using WechatPay to pay " + amount + " RMB.");
    }
}
