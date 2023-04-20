package se.mycar;

//实现Display接口,显示距离

public class DisplayDistanceImpl implements IDisplayInterface {
    DataComputer dataComputer;
    DisplayDistanceImpl(DataComputer dataComputer) {
        this.dataComputer = dataComputer;
    }
    @Override
    public void getDisplay() {
        System.out.println("行驶里程"+dataComputer.getDistance()+"Km");
    }
    
}
