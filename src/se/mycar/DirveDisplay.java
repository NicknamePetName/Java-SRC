package se.mycar;

import java.util.ArrayList;
import java.util.List;

public class DirveDisplay {
    private List<IDisplayInterface> iComputerInterfaces = new ArrayList<>();

    public void addDisplay(IDisplayInterface iComputerInterface) {  //将显示在仪表盘的数据添加到集合中
        iComputerInterfaces.add(iComputerInterface);
    }

    public void getDisplay() {  //显示所有信息到仪表盘上
      for (IDisplayInterface iComputerInterface : iComputerInterfaces) {
        iComputerInterface.getDisplay();
      }
    }
}
