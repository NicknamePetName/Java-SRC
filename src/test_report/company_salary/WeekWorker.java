package test_report.company_salary;

public class WeekWorker extends Employee {


    private int week;
    private double weekSalary;

    WeekWorker(int week,double weekSalary){
        this.week = week;
        this.weekSalary = weekSalary;
    }


    @Override
    public double earnings() {
        return week*weekSalary;
    }
    
}
