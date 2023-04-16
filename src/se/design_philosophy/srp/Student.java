package se.design_philosophy.srp;

public class Student {
    private String name;
    private int age;
    private char gender;
    private int id;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
    
    public int getId() {
        return id;
    }
}
