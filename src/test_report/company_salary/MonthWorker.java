package test_report.company_salary;

public class MonthWorker extends Employee {


    private int month;
    private double monthSalary;

    MonthWorker(int month,double monthSalary){
        this.month = month;
        this.monthSalary = monthSalary;
    }



    @Override
    public double earnings() {
        return month*monthSalary;
    }
    
}
