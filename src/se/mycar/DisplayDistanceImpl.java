package se.mycar;

public class DisplayDistanceImpl implements IComputerInterface {
    DataComputer dataComputer;
    DisplayDistanceImpl(DataComputer dataComputer) {
        this.dataComputer = dataComputer;
    }
    @Override
    public void getDisplay() {
        System.out.println("行驶里程"+dataComputer.getDistance()+"Km");
    }
    
}
