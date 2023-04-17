package se.car_display;

public class Process {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        // 让汽车行驶一段时间
        for (int i = 0; i < 10; i++) {
            dashboard.update();
            System.out.println("当前速度：" + dashboard.getSpeed() + " mph");
            System.out.println("里程数：" + dashboard.getDistance() + " 英里");
            System.out.println("油量：" + dashboard.getFuelLevel() + " 加仑");
            System.out.println();
            try {
                Thread.sleep(1000); // 每秒更新一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        // 加油并行驶一段时间
        System.out.println("加油...");
        dashboard.addFuel(10); // 加10加仑油
        for (int i = 0; i < 10; i++) {
            dashboard.update();
            System.out.println("当前速度：" + dashboard.getSpeed() + " mph");
            System.out.println("里程数：" + dashboard.getDistance() + " 英里");
            System.out.println("油量：" + dashboard.getFuelLevel() + " 加仑");
            System.out.println();
            try {
                Thread.sleep(1000); // 每秒更新一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
