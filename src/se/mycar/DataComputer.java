package se.mycar;


public class DataComputer {

    // 车轮半径
    double R = 0;

    private double mph;    
    private double mpg;
    private double distance;

    DataComputer(double R,DataConvent dataConvents) {   //计算车速，mpg,和行驶距离
        this.R = R;
        this.mph = dataConvents.getValue() * Math.PI * R * 60 / 10000;   
        this.mpg = this.mph / dataConvents.getValue();
        this.distance = this.mph * dataConvents.getTime();
    }

    /* DataComputer(double R,DataConvent dataConvents) {
        this.R = R;
        this.mph = dataConvents.getMph() * Math.PI * R * 60 / 10000;
        this.mpg = this.mph / dataConvents.getMpg();
        this.distance = this.mph * dataConvents.getTime();
    } */

    public double getMph() {
        return mph;
    }

    public double getMpg() {
        
        return mpg;
    }

    public double getDistance() {
        
        return distance;
    }

}
