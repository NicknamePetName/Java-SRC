package se.mycar;



public class DigitalDisplay {
    public static void main(String[] args) {
        ISensorInterface rISensorInterface = new RotatingSignalImpl();//获取转速
        ISensorInterface fISensorInterface = new FuelFlowImpl();//获取燃料流
        DataConvent dataConvent = new DataConvent();//中介（输入控制），将转速，燃料流添加到集合中，传入到数据转换(变换控制)
        dataConvent.addSensor(rISensorInterface);   
        dataConvent.addSensor(fISensorInterface);

        DataComputer dataComputer = new DataComputer(0.6,dataConvent);//数据计算

        //数据输出
        DisplayMphImpl displayMphImpl = new DisplayMphImpl(dataComputer);//显示速度
        DisplayMpgImpl displayMpgImpl = new DisplayMpgImpl(dataComputer);//显示mpg
        DisplayDistanceImpl displayDistanceImpl = new DisplayDistanceImpl(dataComputer);//显示里程
        DirveDisplay dirveDisplay = new DirveDisplay();//输出控制，将上述3中方法添加到集合中
        dirveDisplay.addDisplay(displayMpgImpl);
        dirveDisplay.addDisplay(displayMphImpl);
        dirveDisplay.addDisplay(displayDistanceImpl);
        

        dirveDisplay.getDisplay();//将信息显示到数字仪表盘上
    }
}
