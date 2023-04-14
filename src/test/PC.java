package test;

public class PC {
    private CPU cpu;
    private HardDisk hardDisk;

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void show() {
        System.out.println("cpu速度："+cpu.getSpeed());
        System.out.println("hardDisk容量："+hardDisk.getAmount());
    }
}
