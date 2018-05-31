package br.com.ac.model;

import java.util.List;
import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class Sale implements Model {

    private final ID id;
    private final String salesmanName;
    private final List<SaleItem> items;

    private Sale(ID id, String salesmanName, List<SaleItem> items) {
        this.id = id;
        this.salesmanName = salesmanName;
        this.items = items;
    }

    public static Sale of(ID id, String salesmanName, List<SaleItem> items) {
        Objects.requireNonNull(id, "Id can not be null!");
        Objects.requireNonNull(salesmanName, "salesmanName can not be null!");
        Objects.requireNonNull(items, "items can not be null!");
        if (salesmanName.trim().isEmpty()) throw new IllegalArgumentException("Salesman name can not be empty!");
        if (items.isEmpty()) throw new IllegalArgumentException("Sale need items!");
        return new Sale(id, salesmanName, items);
    }

    public ID getId() {
        return id;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Sale) {
            return Objects.equals(id, ((Sale) other).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", salesmanName='" + salesmanName + '\'' +
                ", items=" + items +
                '}';
    }
}
