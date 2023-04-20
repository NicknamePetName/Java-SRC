package se.design_philosophy.dip;

public class AliPay implements IPaymentInterface {
    public void pay(double amount) {
        System.out.println("Using AliPay to pay " + amount + " RMB.");
    }
    
}
