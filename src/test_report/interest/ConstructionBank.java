package test_report.interest;

public class ConstructionBank extends Bank {
    double year;
    
    @Override
    public double computerInterest() {
        
        super.year = (int)year;

        interest = super.computerInterest()+year*1000%1000*0.0001*savedMoney;

        System.out.println(savedMoney+"元存在建设银行"+super.year+
        "年零"+(int)(year*1000%1000)+"天的利息："+interest+"元");

        return interest;
    }
}
