package br.com.ac.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class Price {

    private final BigDecimal value;

    private Price(BigDecimal value) {
        this.value = value;
    }

    public static Price of(BigDecimal value) {
        Objects.requireNonNull(value);
        if (value.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Price must be >= 0!");
        return new Price(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Price) {
            return Objects.equals(value, ((Price) other).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return Objects.toString(value);
    }
}
