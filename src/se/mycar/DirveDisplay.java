package se.mycar;

import java.util.ArrayList;
import java.util.List;

public class DirveDisplay {
    private List<IComputerInterface> iComputerInterfaces = new ArrayList<>();

    public void addDisplay(IComputerInterface iComputerInterface) {
        iComputerInterfaces.add(iComputerInterface);
    }

    public void getDisplay() {
      for (IComputerInterface iComputerInterface : iComputerInterfaces) {
        iComputerInterface.getDisplay();
      }
    }
}
