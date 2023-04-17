package se.car_display;

/* Alarm 类：该类实现了 SpeedometerListener 接口，负责激活警报。 */

public class Alarm implements SpeedometerListener{
    public void speedExceeded() {
        System.out.println("WARNING: Speed limit exceeded!");
        }
}
