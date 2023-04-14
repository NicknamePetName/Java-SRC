class Device {
    public void run(BUS bus,Operate operate){
        bus.Function();
        operate.receive();
        operate.send();
    }
    void run2(Operate operate){
        operate.receive();
    }
}
abstract class BUS{
    abstract void Function();
}
interface Operate{
    void receive();
    void send();
}
class Rs485 extends BUS implements Operate{
    public void Function(){
        System.out.println("Rs485总线数据采集");
    }

    @Override
    public void receive() {
        throw new UnsupportedOperationException("Unimplemented method 'receive'");
    }

    @Override
    public void send() {
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }
}
class Enthernet extends BUS implements Operate{
    public void Function(){
        System.out.println("以太网数据采控");
    }

    @Override
    public void receive() {
        throw new UnsupportedOperationException("Unimplemented method 'receive'");
    }

    @Override
    public void send() {
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }
}
class CAN extends BUS implements Operate{
    public void Function(){
        System.out.println("CAN总线数据采集");
    }

    @Override
    public void receive() {
        throw new UnsupportedOperationException("Unimplemented method 'receive'");
    }

    @Override
    public void send() {
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }
}
class Program{
    public static void main(String[] args) {
        Device device = new Device();
        Rs485 rs485 =new Rs485();
        Enthernet enthernet =new Enthernet();
        CAN can = new CAN();
        device.run(rs485,rs485);
        device.run(enthernet,enthernet);
        device.run(can,can);
        device.run2(rs485);
    }
}