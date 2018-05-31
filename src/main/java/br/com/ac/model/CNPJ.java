package br.com.ac.model;

import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class CNPJ {

    private final String value;

    private CNPJ(String cnpj) {
        this.value = cnpj;
    }

    public static CNPJ of(String cnpj) {
        Objects.requireNonNull(cnpj);
        if(cnpj.trim().isEmpty()) throw new IllegalArgumentException("CNPJ can not be empty!");

        return new CNPJ(cnpj);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof CNPJ) {
            return Objects.equals(value, ((CNPJ) other).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CNPJ{" +
                "value='" + value + '\'' +
                '}';
    }
}
