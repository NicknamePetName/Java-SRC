package se.mycar;

public class DisplayMphImpl implements IComputerInterface {
    DataComputer dataComputer;
    DisplayMphImpl(DataComputer dataComputer) {
        this.dataComputer = dataComputer;
    }
    @Override
    public void getDisplay() {
        System.out.println(dataComputer.getMph()+"Km/H");
        if (dataComputer.getMph() > 55) {
            System.out.println("发出警报，您已超速！");
        }
    }
    
}
