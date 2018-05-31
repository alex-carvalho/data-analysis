package br.com.ac.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class SaleItems {

    private final List<SaleItem> items;

    private SaleItems(List<SaleItem> items) {
        this.items = items;
    }

    public static SaleItems of(List<SaleItem> items) {
        Objects.requireNonNull(items, "items can not be null!");
        if (items.isEmpty()) throw new IllegalArgumentException("Sale need items!");

        return new SaleItems(items);
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(SaleItem::getTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public int size() {
        return items.size();
    }

    public SaleItem getFirst() {
        return items.get(0);
    }

    @Override
    public String toString() {
        return Objects.toString(items);
    }
}
