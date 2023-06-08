package test;

public class Circle implements Geometry {

    private double R;

    Circle() {
        this.R = 0;
    }

    Circle(double R) {
        this.R = R;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(R, 2);
    }

}
