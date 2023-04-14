package test;


public class Test {
    

    public static void main(String[] args) {
        CPU cpu = new CPU();
        HardDisk hardDisk = new HardDisk();
        PC pc = new PC();


        cpu.setSpeed(2200);
        hardDisk.setAmount(200);
        pc.setCpu(cpu);
        pc.setHardDisk(hardDisk);

        pc.show();

    }


}

