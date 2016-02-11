package model;

import java.util.HashMap;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Order {

    private int id;

    private int xDeliverPos;
    private int yDeliverPos;

    private boolean isDone;

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public void setDone() {
        isDone = true;
    }

    private HashMap<Product, Integer> products = new HashMap<>();

    public Order() {
    }

    public Order(int id, int xDeliverPos, int yDeliverPos) {
        this.id = id;
        this.xDeliverPos = xDeliverPos;
        this.yDeliverPos = yDeliverPos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addProduct(Product p) {
        if (products.containsKey(p)) {
            int count = products.get(p);
            products.put(p, count + 1);
        } else
            products.put(p, 1);
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
