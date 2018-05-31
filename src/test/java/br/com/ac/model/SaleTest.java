package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

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
        Sale.of(ID.of(1L), "A", SaleItems.of(Collections.emptyList()));
    }

    @Test
    public void testEquals() {
        Sale saleFirst = Sale.of(ID.of(1L), "A", getListSaleItemTest());
        Sale saleSecond = Sale.of(ID.of(1L), "B", getListSaleItemTest());

        assertEquals(saleFirst, saleSecond);
    }

    @Test
    public void testTotalSale() {
        SaleItem saleItem1 = SaleItem.of(ID.of(1L), 5, Price.of(new BigDecimal("2")));
        SaleItem saleItem2 = SaleItem.of(ID.of(1L), 5, Price.of(BigDecimal.TEN));

        Sale sale = Sale.of(ID.of(1L), "A", SaleItems.of(Arrays.asList(saleItem1, saleItem2)));

        assertEquals(new BigDecimal((5 * 2) + (5 * 10)), sale.getTotal());
    }

    private SaleItems getListSaleItemTest() {
        return SaleItems.of(Arrays.asList(SaleItem.of(ID.of(1L), 1, Price.of(BigDecimal.ONE))));
    }

}