package se.design_philosophy.isp;


public class Circle implements ICircleInterface {
    @Override
    public void drawCircle() {
        System.out.println("Drawing circle...");
    }
}
