package br.com.ac.model;

import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class Salesman implements Model {

    private CPF cpf;
    private String name;
    private Salary salary;

    private Salesman(CPF cpf, String name, Salary salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public static Salesman of(CPF cpf, String name, Salary salary) {
        Objects.requireNonNull(cpf, "cpf can not be null!");
        Objects.requireNonNull(name, "name can not be null!");
        Objects.requireNonNull(salary, "salary can not be null!");
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Salesman name can not be empty!");

        return new Salesman(cpf, name, salary);
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Salary getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Salesman) {
            return Objects.equals(cpf, ((Salesman) other).cpf);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "cpf=" + cpf +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
