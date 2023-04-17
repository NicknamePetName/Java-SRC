package se.car_display;

/* SpeedSensor 类：该类实现了 Sensor 接口，负责模拟车速传感器，
并提供一个接口以使 Speedometer 类可以读取它的值。 */

public class SpeedSensor implements Sensor {
    @Override
    public double getValue() {
        return Math.random() * 100;
        }
}
