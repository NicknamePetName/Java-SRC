package se.mycar;



public class DigitalDisplay {
    public static void main(String[] args) {
        ISensorInterface rISensorInterface = new RotatingSignalImpl();
        ISensorInterface fISensorInterface = new FuelFlowImpl();
        DataConvent dataConvent = new DataConvent();
        dataConvent.addSensor(rISensorInterface);
        dataConvent.addSensor(fISensorInterface);

        DataComputer dataComputer = new DataComputer(0.6,dataConvent);
        DisplayMphImpl displayMphImpl = new DisplayMphImpl(dataComputer);
        DisplayMpgImpl displayMpgImpl = new DisplayMpgImpl(dataComputer);
        DisplayDistanceImpl displayDistanceImpl = new DisplayDistanceImpl(dataComputer);
        DirveDisplay dirveDisplay = new DirveDisplay();
        dirveDisplay.addDisplay(displayMpgImpl);
        dirveDisplay.addDisplay(displayMphImpl);
        dirveDisplay.addDisplay(displayDistanceImpl);

        dirveDisplay.getDisplay();
        
    }
}
