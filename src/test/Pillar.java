package test;

public class Pillar {
    private Geometry geometry;
    private double height;

    
    Pillar(){};

    Pillar(Geometry geometry,double height) {
        this.geometry = geometry;
        this.height = height;
    }

    public double getVolume() {
        return geometry.getArea()*height;
    }

}
