package test;

import java.util.Random;

public class Test {

    

    

    public static void main(String[] args) {
        Time time = new Time();

        System.out.println(time.getTime());
    }
}

class Time {
    Random random = new Random();
    public double getTime() {
        return random.nextInt(1000);
    }
}