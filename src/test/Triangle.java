package test;

public class Triangle implements Geometry {

    private double oneSide;
    private double twoSide;
    private double threeSide;

    Triangle(double oneSide, double twoSide, double threeSide) {
        this.oneSide = oneSide;
        this.twoSide = twoSide;
        this.threeSide = threeSide;
    }

    @Override
    public double getArea() {
        double semiperimeter = (oneSide+twoSide+threeSide)/2;
        return Math.sqrt(semiperimeter*(semiperimeter-oneSide)*(semiperimeter-twoSide)*(semiperimeter-threeSide));
    }

}
