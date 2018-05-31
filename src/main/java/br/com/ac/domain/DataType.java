package br.com.ac.domain;

import br.com.ac.parser.CustomerParser;
import br.com.ac.parser.Parser;
import br.com.ac.parser.SaleParser;
import br.com.ac.parser.SalesmanParser;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Alex Carvalho
 */
public enum DataType {

    SALESMAN("001") {
        @Override
        public Parser getParser() {
            return SalesmanParser.of();
        }
    },
    CUSTOMER("002") {
        @Override
        public Parser getParser() {
            return CustomerParser.of();
        }
    },
    SALE("003") {
        @Override
        public Parser getParser() {
            return SaleParser.of();
        }
    };

    private final String id;

    DataType(String id) {
        this.id = id;
    }

    public static DataType of(String id) {
        Objects.requireNonNull(id, "id can not be null!");
        if (id.trim().isEmpty()) throw new IllegalArgumentException("DataType id can not be empty!");

        return Stream.of(DataType.values())
                .filter(dt -> dt.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("DataType with id '" + id + "' not found!"));
    }

    public abstract Parser getParser();

}
