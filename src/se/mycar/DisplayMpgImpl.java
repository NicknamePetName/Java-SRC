package se.mycar;


//实现Display接口,显示mpg


public class DisplayMpgImpl implements IDisplayInterface {
    DataComputer dataComputer;
    DisplayMpgImpl(DataComputer dataComputer) {
        this.dataComputer = dataComputer;
    }
    @Override
    public void getDisplay() {
        System.out.println(dataComputer.getMpg()+"Km/L");
    }
    
}
