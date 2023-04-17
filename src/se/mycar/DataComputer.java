package se.mycar;

import java.util.ArrayList;
import java.util.List;

public class DataComputer {
    private List<DataConvent> dataConvents = new ArrayList<>();

    // 计算次数
    private int count = 0;
    // 车轮半径
    private double R = 0;

    DataComputer(double R) {
        this.R = R;
    }

    public void addDataConvent(DataConvent dataConvent) {
        dataConvents.add(dataConvent);
        count++;
    }

    public double getMph() {
        double mph = dataConvents.get(count - 1).getRpm() * Math.PI * R * 60 / 1000;
        return mph;
    }

    public double getMpg() {
        double mpg = (dataConvents.get(count - 1).getRpm() * Math.PI * R * 60 / 1000)
                / dataConvents.get(count - 1).getGph();
        return mpg;
    }

    public double getDistance() {
        double distance = (dataConvents.get(count - 1).getRpm() + dataConvents.get(count).getRpm())
                * Math.abs(dataConvents.get(count).getTime() - dataConvents.get(count - 1).getTime()) 
                * Math.PI * R * 60 / 1000 / 2 / 3600 ;
        return distance;
    }

    public List<DataConvent> getDataConvents() {
        return dataConvents;
    }

}
