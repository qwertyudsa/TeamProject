package BezrukihTest;

import allclasses.Bezrukih.BezrukihClass; // Ensure correct import
import org.junit.Test;

import static org.junit.Assert.*;

public class BezrukihTests {
    @Test
    public void testAdd_PositiveNumbers() {
        assertEquals(5, BezrukihClass.add(2, 3));
    }
    @Test
    public void testAdd_NegativeAndPositiveNumber() {
        assertEquals(0, BezrukihClass.add(-1, 1));
    }
    @Test
    public void testAdd_NegativeNumber() {
        assertEquals(-5, BezrukihClass.add(-2, -3));
    }
    @Test
    public void testIsEven() {
        assertTrue(BezrukihClass.isEven(4));
        assertFalse(BezrukihClass.isEven(3));
        assertTrue(BezrukihClass.isEven(0));
        assertFalse(BezrukihClass.isEven(-1));
    }
    @Test
    public void testFactorial() {
        assertEquals(1, BezrukihClass.factorials(0));
        assertEquals(1, BezrukihClass.factorials(1));
        assertEquals(2, BezrukihClass.factorials(2));
        assertEquals(6, BezrukihClass.factorials(3));
        assertEquals(24, BezrukihClass.factorials(4));
        assertEquals(120, BezrukihClass.factorials(5));
    }

    @Test
    public void testFactorialNegativeNumber() {
        try {
            BezrukihClass.factorials(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("n must be non-negative", e.getMessage());
        }
    }
}
