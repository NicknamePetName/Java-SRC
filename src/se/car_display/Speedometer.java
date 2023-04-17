package se.car_display;

import java.util.ArrayList;
import java.util.List;

/* Speedometer 类：该类负责监测车速，并根据需要激活警报。 */

public class Speedometer {
    private Sensor speedSensor;
    private List<SpeedometerListener> listeners;

    public Speedometer(Sensor speedSensor) {
        this.speedSensor = speedSensor;
        this.listeners = new ArrayList<SpeedometerListener>();
    }

    public void addListener(SpeedometerListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(SpeedometerListener listener) {
        this.listeners.remove(listener);
    }

    public void checkSpeed() {
        double speed = this.speedSensor.getValue();
        if (speed > 55) {
            for (SpeedometerListener listener : this.listeners) {
                listener.speedExceeded();
            }
        }
    }

    public int getSpeed() {
        return 0;
    }
}
