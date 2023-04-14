package test_report.animalcry;

public class Simulator {
    void playSound(Animal animal){
        System.out.print( animal.getAnimarlName() + " may cry like this: ");
		animal.cry();
    }
}
