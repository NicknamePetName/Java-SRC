package se.mycar;
//实现了Sensor接口，获取转速，并提供一个接口以使其他类可以读取它。
public class RotatingSignalImpl implements ISensorInterface {

    private double rev;

    RotatingSignalImpl(){
        this.rev = Math.random() * 10000;    //获取旋转信号并转换为转速
    }

    @Override
    public double getValue(){
        return rev;                          
    }
}
