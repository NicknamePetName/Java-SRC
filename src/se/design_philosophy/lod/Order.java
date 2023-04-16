package se.design_philosophy.lod;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items = new ArrayList<>();
    // ...

    public List<Product> getItems() {
        return items;
    }
}
