package br.com.ac.parser;

import br.com.ac.model.Model;

import java.util.StringTokenizer;

/**
 * @author Alex Carvalho
 */
public interface Parser<T extends Model> {

    T parse(String line);

    default StringTokenizer split(String line) {
        return split(line, "ç");
    }

    default StringTokenizer split(String line, String delim) {
        return new StringTokenizer(line, delim);
    }
}
