package BezrukihTest;

import allclasses.Bezrukih.BezrukihClass; // Ensure correct import
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testAdd_NegativeNumbers() {
        assertEquals(-5, BezrukihClass.add(-2, -3));
    }
    @Test
    public void testIsEvent() {
        assertTrue(BezrukihClass.isEven(4));
        assertFalse(BezrukihClass.isEven(3));
        assertTrue(BezrukihClass.isEven(0));
        assertFalse(BezrukihClass.isEven(-1));
    }
    @Test
    public void testFactorial() {
        assertEquals(1, BezrukihClass.factorial(0));
        assertEquals(1, BezrukihClass.factorial(1));
        assertEquals(2, BezrukihClass.factorial(2));
        assertEquals(6, BezrukihClass.factorial(3));
        assertEquals(24, BezrukihClass.factorial(4));
        assertEquals(120, BezrukihClass.factorial(5));
    }

    @Test
    public void testFactorialNegativeNumber() {
        try {
            BezrukihClass.factorial(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("n must be non-negative", e.getMessage());
        }
    }
}
