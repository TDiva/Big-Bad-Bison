package model;

/**
 * Created by TDiva on 2/11/16.
 */
public class Product {
    private int typeCode;
    private int weight;

    public Product() {
    }

    public Product(int typeCode, int weight) {
        this.typeCode = typeCode;
        this.weight = weight;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
