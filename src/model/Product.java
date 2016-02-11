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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return typeCode == product.typeCode && weight == product.weight;

    }

    @Override
    public int hashCode() {
        int result = typeCode;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "typeCode=" + typeCode +
                ", weight=" + weight +
                '}';
    }
}
