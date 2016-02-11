package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Warehouse {

    private int id;
    private int xPos;
    private int yPos;
    private HashMap<Product, Integer> products; // key - product # ; value product count

    public Warehouse() {
    }

    public Warehouse(int id, int xPos, int yPos) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public void addProduct(Product p, int count) {
        products.put(p, count);
    }

    public boolean hasAllItems(Map<Product, Integer> order) {

        boolean flag = true;
        for (Product k: order.keySet()) {
            if (!products.containsKey(k) || products.get(k) < order.get(k))
                flag = false;
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                ", products=" + products +
                '}';
    }
}
