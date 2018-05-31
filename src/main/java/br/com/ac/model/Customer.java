package br.com.ac.model;

import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class Customer {

    private final CNPJ cnpj;
    private final String name;
    private final String businessArea;

    private Customer(CNPJ cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public static Customer of(CNPJ cnpj, String name, String businessArea) {
        Objects.requireNonNull(cnpj);
        Objects.requireNonNull(name);
        Objects.requireNonNull(businessArea);
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Customer name can not be empty!");
        if (businessArea.trim().isEmpty()) throw new IllegalArgumentException("Customer business area can not be empty!");

        return new Customer(cnpj, name, businessArea);
    }

    public CNPJ getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Customer) {
            return Objects.equals(cnpj, ((Customer) other).cnpj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cnpj=" + cnpj +
                ", name='" + name + '\'' +
                ", businessArea='" + businessArea + '\'' +
                '}';
    }
}
