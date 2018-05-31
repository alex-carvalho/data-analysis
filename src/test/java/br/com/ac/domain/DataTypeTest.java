package br.com.ac.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class DataTypeTest {

    @Test(expected = NullPointerException.class)
    public void testNullType() {
        DataType.of(null);
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyType() {
        DataType.of(" ");
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidType() {
        DataType.of("aaa");
    }

    @Test
    public void testValidType() {
        DataType type = DataType.of("001");

        assertEquals(DataType.SALESMAN, type);
    }

}