package se.mycar;

public class Display {
    public static void main(String[] args) {
        ISensorInterface rISensorInterface = new RotatingSignalImpl();
        ISensorInterface fISensorInterface = new FuelFlowImpl();
        DataConvent dataConvent = new DataConvent();
        dataConvent.addSensor(rISensorInterface);
        dataConvent.addSensor(fISensorInterface);

        DataComputer dataComputer = new DataComputer(0.6,dataConvent);
        DrivePanel drivePanel = new DrivePanel(dataComputer);

        drivePanel.getMpg();
        drivePanel.getMph();
        drivePanel.getDistance();
    }
}
