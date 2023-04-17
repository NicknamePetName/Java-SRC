package se.car_display;

/* Dashboard 类：该类是整个数字仪表板的控制中心，
负责创建和协调所有其他类的实例，
并提供一个接口以使外部类可以访问它们。 */

public class Dashboard {
    private Speedometer speedometer;
    private Odometer odometer;
    private FuelGauge fuelGauge;

    public Dashboard() {
        this.speedometer = new Speedometer(new SpeedSensor());
        this.odometer = new Odometer();
        this.fuelGauge = new FuelGauge();
        this.speedometer.addListener(new Alarm());
    }

    public void update() {
        double miles = this.speedometer.getSpeed() / 60;
        this.odometer.updateDistance(miles);
        double gallons = miles / 25;
        this.fuelGauge.burnFuel(gallons);
    }

    public void addFuel(double gallons) {
        this.fuelGauge.addFuel(gallons);
    }

    public double getSpeed() {
        return this.speedometer.getSpeed();
    }

    public double getDistance() {
        return this.odometer.getDistance();
    }

    public double getFuelLevel() {
        return this.fuelGauge.getFuelLevel();
    }
}
