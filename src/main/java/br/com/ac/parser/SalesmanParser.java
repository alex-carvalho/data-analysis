package br.com.ac.parser;

import br.com.ac.model.CPF;
import br.com.ac.model.Salary;
import br.com.ac.model.Salesman;

import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * @author Alex Carvalho
 */
public class SalesmanParser implements Parser<Salesman> {

    private SalesmanParser() {
    }

    public static SalesmanParser of() {
        return new SalesmanParser();
    }

    @Override
    public Salesman parse(String line) {
        StringTokenizer tokens = split(line);

        if (tokens.countTokens() < 3) throw new RuntimeException("SalesmanParser tokens countTokens < 3");

        CPF cpf = CPF.of(tokens.nextToken());
        String name = tokens.nextToken();
        Salary salary = Salary.of(new BigDecimal(tokens.nextToken()));

        return Salesman.of(cpf, name, salary);
    }
}
