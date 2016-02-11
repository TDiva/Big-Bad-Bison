package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Warehouse {

    private int xPos;
    private int yPos;
    private HashMap<Product, Integer> products; // key - product # ; value product count

    public Warehouse() {
    }

    public Warehouse(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
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

    public boolean hasAllItems(Map<Product, Integer> order) {

        boolean flag = true;
        for (Product k: order.keySet()) {
            if (!products.containsKey(k) || products.get(k) < order.get(k))
                flag = false;
        }
        return flag;
    }
}
