package se.design_philosophy.isp;

public class Process {

    public static void main(String[] args) {

        ICircleInterface iCircleInterface = new Circle();
        IRectangleInterface iRectangleInterface = new Rectangle();
        Drawing drawing = new Drawing(iCircleInterface, null, iRectangleInterface);
        drawing.drawCircle();
        drawing.drawRectangle();

    }

}
