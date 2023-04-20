package se.mycar;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//整合数据

public class DataConvent { 
    private List<ISensorInterface> iSensorInterfaces= new ArrayList<>();  //Sensor接口集合
    int count = 0;//用来获取集合下一个元素
    public void addSensor(ISensorInterface iSensor) {      //add   FuelFlowImpl,RotatingSignalImpl
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
    public double getTime(){         //获得时间
        Random random = new Random();
        return random.nextInt(10);
    }

}
