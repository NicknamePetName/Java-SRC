package test_report.company_salary;

public class Payoff {

    public static void main(String[] args) {

        // 定义一个employee类对象数组
        Employee[] employee = new Employee[3];

        

        // employee[0]是YearWorker的上转型对象
        employee[0] = new YearWorker(1, 48000.0);

        // employee[1]是MonthWorker的上转型对象
        employee[1] = new MonthWorker(12, 4000.0);

        // employee[2]是WeekWorker的上转型对象
        employee[2] = new WeekWorker(48, 1000.0);

        double sumSalary = 0;

        Company com = new Company(employee);


        //法一
        /* sumSalary = com.employee[0].earnings() +com.employee[1].earnings() +com.employee[2].earnings(); */
        

        //法二
        for (Employee companySalary : com.employee) {
            sumSalary += companySalary.earnings();
        }


        //法三
        /* sumSalary = employee[0].earnings() + employee[1].earnings() + employee[2].earnings(); // 可以改成循环结构*/
        

        //法四
        /* for (Employee companySalary : employee) {
        sumSalary += companySalary.earnings();
        } */

        System.out.println("公司支出的总薪水为:" + sumSalary);

    }

}
