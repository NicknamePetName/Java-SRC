package se.mycar;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//负责计算rpm、gph，并提供一个接口以使其他类可以读取它。

public class DataConvent { 
    private List<ISensorInterface> iSensorInterfaces;
    public void addSensor(ISensorInterface iSensor) {
        iSensorInterfaces = new ArrayList<>();
        iSensorInterfaces.add(iSensor);
    }


    public double getRpm() {
        double rpm = iSensorInterfaces.get(0).getValue() * 10000;
        return rpm;
    }
    public double getGph() {
        double gph = iSensorInterfaces.get(1).getValue() *10;
        return gph;
    }
    public List<ISensorInterface> getiSensorInterfaces() {
        return iSensorInterfaces;
    }
    public double getTime(){
        Random random = new Random();
        return random.nextInt(1000);
    }

}
