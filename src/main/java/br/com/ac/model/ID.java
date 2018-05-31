package br.com.ac.model;

import java.util.Objects;

/**
 * @author Alex Carvalho
 */
public class ID {

    private final Long value;

    private ID(Long id) {
        this.value = id;
    }

    public static ID of(Long id) {
        Objects.requireNonNull(id, "id can not be null!");
        if (id <= 0) throw new IllegalArgumentException("Id must be > 0!");

        return new ID(id);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ID) {
            return Objects.equals(value, ((ID) other).getValue());
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID{" +
                "value=" + value +
                '}';
    }
}
