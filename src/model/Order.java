package model;

import java.util.HashMap;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Order {

    private int xDeliverPos;
    private int yDeliverPos;

    private HashMap<Product, Integer> products;

    public Order() {
    }

    public Order(int xDeliverPos, int yDeliverPos) {
        this.xDeliverPos = xDeliverPos;
        this.yDeliverPos = yDeliverPos;
    }

    public int getxDeliverPos() {
        return xDeliverPos;
    }

    public void setxDeliverPos(int xDeliverPos) {
        this.xDeliverPos = xDeliverPos;
    }

    public int getyDeliverPos() {
        return yDeliverPos;
    }

    public void setyDeliverPos(int yDeliverPos) {
        this.yDeliverPos = yDeliverPos;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "xDeliverPos=" + xDeliverPos +
                ", yDeliverPos=" + yDeliverPos +
                ", products=" + products +
                '}';
    }
}
