package se.mycar;


public class DataComputer {

    // 车轮半径
    double R = 0;

    double mph;
    double mpg;
    double distance;

    DataComputer(double R,DataConvent dataConvents) {
        this.R = R;
        this.mph = dataConvents.getRpm() * Math.PI * R * 60 / 1000;
        this.mpg = this.mph / dataConvents.getGph();
        this.distance = this.mph * dataConvents.getTime();
    }

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
