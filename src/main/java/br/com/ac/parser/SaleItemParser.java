package br.com.ac.parser;

import br.com.ac.model.ID;
import br.com.ac.model.Price;
import br.com.ac.model.SaleItem;

import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * @author Alex Carvalho
 */
public class SaleItemParser implements Parser<SaleItem> {

    private SaleItemParser() {
    }

    public static SaleItemParser of() {
        return new SaleItemParser();
    }

    @Override
    public SaleItem parse(String line) {
        StringTokenizer tokens = split(line, "-");

        if (tokens.countTokens() < 3) throw new RuntimeException("SaleItemParser tokens countTokens < 3");

        ID id = ID.of(Long.valueOf(tokens.nextToken()));
        Integer quantity = Integer.valueOf(tokens.nextToken());
        Price price = Price.of(new BigDecimal(tokens.nextToken()));

        return SaleItem.of(id, quantity, price);
    }
}
