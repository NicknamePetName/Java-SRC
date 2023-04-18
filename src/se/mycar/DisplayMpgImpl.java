package se.mycar;

public class DisplayMpgImpl implements IComputerInterface {
    DataComputer dataComputer;
    DisplayMpgImpl(DataComputer dataComputer) {
        this.dataComputer = dataComputer;
    }
    @Override
    public void getDisplay() {
        System.out.println(dataComputer.getMpg()+"Km/L");
    }
    
}
