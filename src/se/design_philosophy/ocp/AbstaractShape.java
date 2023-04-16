package se.design_philosophy.ocp;

public abstract class AbstaractShape implements IShapeInterface{
    @Override
    public double getArea(){
        return 0;
    }
    @Override
    public double getPerimeter() {
        return 0;
    }

    public abstract void draw();
}
