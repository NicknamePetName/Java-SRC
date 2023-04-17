package se.mycar;

//实现了Sensor接口，获取燃料流，并提供一个接口以使其他类可以读取它。
public class FuelFlowImpl implements ISensorInterface {

    private double oil;

    FuelFlowImpl(){
        this.oil = Math.random();
    }

    @Override
    public double getValue(){
        return oil;
    }
    
}
