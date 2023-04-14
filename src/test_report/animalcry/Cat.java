package test_report.animalcry;

public class Cat implements Animal {

    String name;

    Cat(String string){
        name = string;
    }


    @Override
    public void cry() {
        System.out.println("大猫叫");
    }

    @Override
    public String getAnimarlName() {
        return name;
    }
    
}
