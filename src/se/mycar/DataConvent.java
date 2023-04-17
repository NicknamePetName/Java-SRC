package se.mycar;

import java.util.ArrayList;
import java.util.List;

//负责计算rpm、gph，并提供一个接口以使其他类可以读取它。

public class DataConvent {

    private List<ISensorInterface> iSensorInterfaces = new ArrayList<>();
    private double rpm;
    private double gph;


    FuelFlowImpl fuelFlowImpl = new FuelFlowImpl();
    RotatingSignalImpl rotatingSignalImpl = new RotatingSignalImpl();

    DataConvent(ISensorInterface rotatingSignalImpl,ISensorInterface fuelFlowImpl) {
        rpm = rotatingSignalImpl.getValue() * 10000;
        gph = fuelFlowImpl.getValue() * 1000;
    }

    
    public double getRpm() {
        iSensorInterfaces.add(0, fuelFlowImpl);
        return rpm;
    }

    public double getGph() {
        return gph;
    }

}
