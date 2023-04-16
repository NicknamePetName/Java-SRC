package se.design_philosophy.ocp;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<IShapeInterface> shapes = new ArrayList<>();

    public void addShape(IShapeInterface shape) {
        shapes.add(shape);
    }

    public void drawAll() {
        for (IShapeInterface shape : shapes) {
            shape.draw();
        }
    }
}
