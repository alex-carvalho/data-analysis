package br.com.ac.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class Salary {

    private final BigDecimal value;

    private Salary(BigDecimal value) {
        this.value = value;
    }

    public static Salary of(BigDecimal value) {
        Objects.requireNonNull(value, "salary can not be null!");
        if (value.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Salary must be >= 0!");
        return new Salary(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Salary) {
            return Objects.equals(value, ((Salary) other).value);
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
