package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Warehouse {

    private int id;
    private int xPos;
    private int yPos;
    private HashMap<Product, Integer> products = new HashMap<>(); // key - product # ; value product count

    public int wayTo(int x, int y) {
        return (int) Math.floor(Math.sqrt(Math.pow(xPos - x, 2) + Math.pow(yPos - y, 2)) - 0.00001) + 1;
    }


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

    public Map<Product, Integer> getListofAvailable(Map<Product, Integer> order) {
        Map<Product, Integer> available = new HashMap<>();
        for (Product k: order.keySet()) {
            if (products.containsKey(k)) {
                available.put(k, Math.min(products.get(k), order.get(k)));
            }

        }
        return available;
    }

    public static boolean hasAllItems2(HashMap<Product, Integer> order, Warehouse ... wars) {
        Map<Product,Integer> all = new HashMap<>();
        for (Warehouse w :wars) {
            for (Product p: w.getProducts().keySet()) {
                if (all.containsKey(p)) {
                    all.put(p, all.get(p) + w.getProducts().get(p));
                } else {
                    all.put(p, w.getProducts().get(p));
                }
            }
        }

        boolean flag = true;
        for (Product k: order.keySet()) {
            if (!all.containsKey(k) || all.get(k) < order.get(k))
                flag = false;
        }
        return flag;
    }

    public void ejectProducts(Map<Product, Integer> eject) {
        for (Product p: eject.keySet()) {
            if (products.get(p) == eject.get(p))
                products.remove(p);
            else
                products.put(p, products.get(p) - eject.get(p));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse)) return false;

        Warehouse warehouse = (Warehouse) o;

        return id == warehouse.id;

    }

    @Override
    public int hashCode() {
        return id;
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
