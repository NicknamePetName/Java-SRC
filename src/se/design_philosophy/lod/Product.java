package se.design_philosophy.lod;

public class Product {
    private String name;
    private int id;
    private double price;
    // ...


    //解除错误
    void print(){
        System.out.println(name+id+price);
    }
}