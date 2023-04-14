package test_report.fan;

public class Process {
    // public static final int SLOW = 1,MEDIUM = 2,FAST = 3;

    public static void main(String[] args) {
        Fan fanFirst = new Fan();
        Fan fanSecond = new Fan();

        fanFirst.setSpeed(Fan.FAST);
        fanFirst.setRadius(10);
        fanFirst.setColor("yellow");
        fanFirst.setOn(true);
        System.out.println(fanFirst.toString());

        fanSecond.setSpeed(Fan.MEDIUM);
        fanSecond.setRadius(5);
        fanSecond.setColor("blue");
        fanSecond.setOn(false);
        System.out.println(fanSecond.toString());

    
    }
}
