package se.car_display;

/* Sensor 接口：定义了传感器所必须具有的功能。
每个传感器都必须实现这个接口，以便它们可以与汽车的微处理器交互。 */

public interface Sensor {
    public double getValue();
}


