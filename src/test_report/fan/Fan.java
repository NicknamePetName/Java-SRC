package test_report.fan;


public class Fan {
    public static final int SLOW = 1,MEDIUM = 2,FAST = 3;
    private int speed = SLOW;
    private boolean on;
    private double radius = 5;
    public String color = "blue";

    Fan(){};

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
    public boolean getOn() {
        return on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public String toString(){
        if (on) {
            return "speed:"+speed+" "+"color:"+color+" "+"radius:"+radius;
        } else {
            return "fan is off";
        }
    }
}
