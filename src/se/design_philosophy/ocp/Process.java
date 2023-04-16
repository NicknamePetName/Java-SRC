package se.design_philosophy.ocp;

public class Process {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(3, 4, 5);

        Drawing drawing = new Drawing();
        drawing.addShape(circle);
        drawing.addShape(rectangle);
        drawing.addShape(triangle);

        drawing.drawAll();
    }
}
