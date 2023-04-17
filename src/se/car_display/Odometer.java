package se.car_display;

/* Odometer 类：该类负责计算行驶里程，
并提供一个接口以使其他类可以读取它。 */

public class Odometer {
    private double distance;

    public Odometer() {
        this.distance = 0;
    }

    public void updateDistance(double miles) {
        this.distance += miles;
    }

    public double getDistance() {
        return this.distance;
    }
}
