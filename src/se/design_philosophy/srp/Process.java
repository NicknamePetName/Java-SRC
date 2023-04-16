package se.design_philosophy.srp;

public class Process {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setAge(20);
        student.setGender('M');
        student.setId(10001);
        
        Course course = new Course();
        course.setName("Java基础");
        course.setCourseName("C001");
        course.setScore(90);
        
        System.out.println("学生姓名：" + student.getName());
        System.out.println("学生年龄：" + student.getAge());
        System.out.println("学生性别：" + student.getGender());
        System.out.println("学生学号：" + student.getId());
        System.out.println("课程名称：" + course.getName());
        System.out.println("课程编号：" + course.getCourseName());
        System.out.println("课程成绩：" + course.getScore());
    }
}
