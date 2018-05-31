package br.com.ac.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class Sale implements Model {

    private final ID id;
    private final String salesmanName;
    private final SaleItems saleItems;

    private Sale(ID id, String salesmanName, SaleItems saleItems) {
        this.id = id;
        this.salesmanName = salesmanName;
        this.saleItems = saleItems;
    }

    public static Sale of(ID id, String salesmanName, SaleItems saleItems) {
        Objects.requireNonNull(id, "Id can not be null!");
        Objects.requireNonNull(salesmanName, "salesmanName can not be null!");
        Objects.requireNonNull(saleItems, "saleItems can not be null!");
        if (salesmanName.trim().isEmpty()) throw new IllegalArgumentException("Salesman name can not be empty!");
        return new Sale(id, salesmanName, saleItems);
    }

    public ID getId() {
        return id;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public SaleItems getSaleItems() {
        return saleItems;
    }

    public BigDecimal getTotal() {
        return saleItems.getTotal();
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
                ", items=" + saleItems +
                '}';
    }
}
