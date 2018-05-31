package br.com.ac.parser;

import br.com.ac.model.ID;
import br.com.ac.model.Sale;
import br.com.ac.model.SaleItem;
import br.com.ac.model.SaleItems;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Alex Carvalho
 */
public class SaleParser implements Parser<Sale> {

    private SaleParser() {
    }

    public static SaleParser of() {
        return new SaleParser();
    }

    @Override
    public Sale parse(String line) {
        StringTokenizer tokens = split(line);

        if (tokens.countTokens() < 3) throw new RuntimeException("SaleParser tokens countTokens < 3");

        ID id = ID.of(Long.valueOf(tokens.nextToken()));
        List<SaleItem> items = parseItens(tokens.nextToken());
        String salesmanName = tokens.nextToken();

        return Sale.of(id, salesmanName, SaleItems.of(items));
    }

    private List<SaleItem> parseItens(String token) {
        List<SaleItem> items = new ArrayList<>();

        String a = token.substring(1, token.length() - 1);

        StringTokenizer tokenizer = split(a, ",");

        while (tokenizer.hasMoreTokens()) {
            items.add(SaleItemParser.of().parse(tokenizer.nextToken()));
        }

        return items;
    }
}
