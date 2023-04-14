package test_report.interest;

public class Computer {
    public static void main(String[] args) {
        //50000元在建设银行存5年零216天的利息。
		ConstructionBank bank1=new ConstructionBank();
		bank1.year=5.216;
		bank1.savedMoney=50000;
		bank1.computerInterest();
		
		//50000元在青岛银行存5年零216天的利息。
		BankOfQingdao bank2=new BankOfQingdao();
		bank2.year=5.216;
		bank2.savedMoney=50000;
		bank2.computerInterest();
		//利息差额
		System.out.println("利息差额："+Math.abs(bank1.interest-bank2.interest));	 

        //8000元存在商业银行8年零236天的利息.		
		CommercialBank bank3=new CommercialBank();
		bank3.year=8.236;
		bank3.savedMoney=8000;
		bank3.computerInterest();
       

    }
}
