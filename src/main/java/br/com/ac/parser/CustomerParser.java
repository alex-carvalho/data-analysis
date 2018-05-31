package br.com.ac.parser;

import br.com.ac.model.CNPJ;
import br.com.ac.model.Customer;

import java.util.StringTokenizer;

/**
 * @author Alex Carvalho
 */
public class CustomerParser implements Parser<Customer> {

    private CustomerParser() {
    }

    public static CustomerParser of() {
        return new CustomerParser();
    }

    @Override
    public Customer parse(String line) {
        StringTokenizer tokens = split(line);

        if (tokens.countTokens() < 3) throw new RuntimeException("CustomerParser tokens countTokens < 3");

        CNPJ cnpj = CNPJ.of(tokens.nextToken());
        String name = tokens.nextToken();
        String businessArea = tokens.nextToken();

        return Customer.of(cnpj, name, businessArea);
    }
}
