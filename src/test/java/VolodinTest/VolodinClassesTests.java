package VolodinTest;

import allclasses.Volodin.VolodinClasses;
import org.junit.Test;

import static org.junit.Assert.*;

public class VolodinClassesTests {
    @Test
    public void testSubtract() {
        assertEquals(3, VolodinClasses.subtract(5, 2));
        assertEquals(-5, VolodinClasses.subtract(0, 5));
        assertEquals(0, VolodinClasses.subtract(5, 5));
        assertEquals(7, VolodinClasses.subtract(10, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(10, VolodinClasses.multiply(2, 5));
        assertEquals(0, VolodinClasses.multiply(0, 10));
        assertEquals(-15, VolodinClasses.multiply(3, -5));
        assertEquals(16, VolodinClasses.multiply(-4, -4));
    }

    @Test
    public void testIsPositive() {
        assertTrue(VolodinClasses.isPositive(5));
        assertFalse(VolodinClasses.isPositive(0));
        assertFalse(VolodinClasses.isPositive(-3));
        assertTrue(VolodinClasses.isPositive(100));
    }
}
