package se.car_display;

/* 类：该类负责计算汽车的油量，
并提供一个接口以使其他类可以读取它。 */

public class FuelGauge {
    private double fuelLevel;

    public FuelGauge() {
        this.fuelLevel = 0;
    }

    public void addFuel(double gallons) {
        this.fuelLevel += gallons;
    }

    public void burnFuel(double gallons) {
        if (this.fuelLevel >= gallons) {
            this.fuelLevel -= gallons;
        }
    }
    public double getFuelLevel() {
        return this.fuelLevel;
    }

}