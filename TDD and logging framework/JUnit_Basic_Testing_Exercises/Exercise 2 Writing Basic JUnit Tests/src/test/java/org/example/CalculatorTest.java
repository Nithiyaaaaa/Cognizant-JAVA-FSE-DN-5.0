package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(30, calc.add(10, 20));
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.subtract(20, 10));
    }
}