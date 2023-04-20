package se.mycar;
//实现Display接口，显示速度，并且超速警报
public class DisplayMphImpl implements IDisplayInterface {
    DataComputer dataComputer;
    DisplayMphImpl(DataComputer dataComputer) {
        this.dataComputer = dataComputer;
    }
    @Override
    public void getDisplay() {
        System.out.println(dataComputer.getMph()+"Km/H");
        if (dataComputer.getMph() > 30) {
            System.out.println("加速");
            if (dataComputer.getMph() > 55) {
                System.out.println("发出警报，您已超速！");
            }
        }else if (dataComputer.getMph() <30) {
            System.out.println("减速");
        }else {
            System.out.println("匀速行驶");
        }  
    }
    
}
