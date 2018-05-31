package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class SaleTest {

    @Test(expected = NullPointerException.class)
    public void testNullID() {
        Sale.of(null, "A", getListSaleItemTest());
    }

    @Test(expected = NullPointerException.class)
    public void testNullSalesmanName() {
        Sale.of(ID.of(1L), null, getListSaleItemTest());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptySalesmanName() {
        Sale.of(ID.of(1L), " ", getListSaleItemTest());
    }

    @Test(expected = NullPointerException.class)
    public void testNullItems() {
        Sale.of(ID.of(1L), "A", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyItems() {
        Sale.of(ID.of(1L), "A", Collections.emptyList());
    }

    @Test
    public void testEquals() {
        Sale saleFirst = Sale.of(ID.of(1L), "A", getListSaleItemTest());
        Sale saleSecond = Sale.of(ID.of(1L), "B", getListSaleItemTest());

        assertEquals(saleFirst, saleSecond);
    }

    private List<SaleItem> getListSaleItemTest() {
        return Arrays.asList(SaleItem.of(ID.of(1L), 1, Price.of(BigDecimal.ONE)));
    }

}