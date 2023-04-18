package se.mycar;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//负责计算rpm、gph，并提供一个接口以使其他类可以读取它。

public class DataConvent { 
    private List<ISensorInterface> iSensorInterfaces= new ArrayList<>();
    int count = 0;
    public void addSensor(ISensorInterface iSensor) {
        iSensorInterfaces.add(iSensor);
    }

    public double getValue() {
        return iSensorInterfaces.get(count++).getValue();
    }

    // public double getRpm() {
    //     double rpm = iSensorInterfaces.get(0).getValue() ;
    //     return rpm;
    // }
    // public double getGph() {
    //     double gph = iSensorInterfaces.get(1).getValue() ;
    //     return gph;
    // }
    public List<ISensorInterface> getiSensorInterfaces() {
        return iSensorInterfaces;
    }
    public double getTime(){
        Random random = new Random();
        return random.nextInt(10);
    }

}
