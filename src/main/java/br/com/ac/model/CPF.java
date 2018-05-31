package br.com.ac.model;

import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class CPF {

    private final String value;

    private CPF(String cpf) {
        this.value = cpf;
    }

    public static CPF of(String cpf) {
        Objects.requireNonNull(cpf, "cpf can not be null!");
        if (cpf.trim().isEmpty()) throw new IllegalArgumentException("CPF can not be empty!");

        return new CPF(cpf);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof CPF) {
            return Objects.equals(value, ((CPF) other).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CPF{" +
                "value='" + value + '\'' +
                '}';
    }
}
