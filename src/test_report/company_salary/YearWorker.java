package test_report.company_salary;

public class YearWorker extends Employee {

    private int year;
    private double yearSalary;

    YearWorker(int year,double yearSalary){
        this.year = year;
        this.yearSalary = yearSalary;
    }

    @Override
    public double earnings() {
        return year*yearSalary;
    }
    
}
