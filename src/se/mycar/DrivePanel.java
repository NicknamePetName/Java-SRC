package se.mycar;

public class DrivePanel {
    private double mpg;
    private double mph;
    private double distance;

    DrivePanel(DataComputer dataComputer){
        mpg = dataComputer.getMpg();
        mph = dataComputer.getMph();
        distance = dataComputer.getDistance();

    }

    public void getMpg() {
        System.out.println(mpg+"Km/H");
        if (mpg > 55) {
            System.out.println("发出警报，您已超速！");
        }
    }
    public void getMph() {
        System.out.println(mph+"Km/L");
    }
    public void getDistance() {
        System.out.println("行驶里程："+distance+"Km");
    }
    
}
