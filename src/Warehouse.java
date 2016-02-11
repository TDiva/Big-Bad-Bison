import java.util.HashMap;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Warehouse {

    private int xPos;
    private int yPos;
    private HashMap<Integer, Integer> products; // key - product # ; value product count

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

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }
}
