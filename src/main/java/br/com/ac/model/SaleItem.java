package br.com.ac.model;

import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class SaleItem {

    private final ID id;
    private final Integer quantity;
    private final Price price;

    private SaleItem(ID id, Integer quantity, Price price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public static SaleItem of(ID id, Integer quantity, Price price) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(price);
        Objects.requireNonNull(quantity);
        if (quantity <= 0) throw new IllegalArgumentException("Salary must be > 0!");

        return new SaleItem(id, quantity, price);
    }

    public ID getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SaleItem) {
            return Objects.equals(id, ((SaleItem) other).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
