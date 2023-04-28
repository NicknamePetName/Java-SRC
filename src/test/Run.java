package test;


public class Run {
    public static void main(String[] args) {
        Process process = new Process();
        process.setA(5);
        System.out.println(process.getA());
        System.out.println(process.getB());
    }
}