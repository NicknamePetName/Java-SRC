package se.design_philosophy.lod;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int id;
    // ...

    public List<Product> getRecentOrderProducts() {
        List<Product> products = new ArrayList<>();
        List<Order> orders = getRecentOrders(); // 获取最近订单
        for (Order order : orders) {
            products.addAll(order.getItems()); // 获取订单中的商品
        }
        return products;
    }

    private List<Order> getRecentOrders() {
        return null;
        // 获取最近订单的逻辑
    }


    void print(){
        System.out.println(name+id);
    }
}