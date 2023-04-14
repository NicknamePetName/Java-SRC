package test_report.animalcry;

public class Dog implements Animal {

    String name;

    Dog(String string){
        this.name = string;
    }

    @Override
    public void cry() {
        System.out.println("大黄叫");
    }

    @Override
    public String getAnimarlName() {
        return name;
    }
    
}
