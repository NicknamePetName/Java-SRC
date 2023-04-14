package test_report.animalcry;

public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
	    simulator.playSound(new Dog("藏獒"));
	    simulator.playSound(new Cat("加菲猫"));
    }
}
