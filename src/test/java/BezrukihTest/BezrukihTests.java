package BezrukihTest;

import allclasses.Bezrukih.BezrukihClass; // Ensure correct import
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.junit.Test;

import static org.junit.Assert.*;

public class BezrukihTests {
    @Test
    @Description("Я лешка")
    public void testAdd_PositiveNumbers() {
        assertEquals(5, BezrukihClass.add(2, 3));
    }
    @Test
    @Description("Пиу пиу пиу")
    public void testAdd_NegativeAndPositiveNumber() {
        assertEquals(0, BezrukihClass.add(-1, 1));
    }
    @Test
    public void testAdd_NegativeNumber() {
        assertEquals(-5, BezrukihClass.add(-2, -3));
    }
    @Test
    @Step("первый тест")
    public void testIsEven() {
        assertTrue(BezrukihClass.isEven(4));
        assertFalse(BezrukihClass.isEven(3));
        assertTrue(BezrukihClass.isEven(0));
        assertFalse(BezrukihClass.isEven(-1));
    }
    @Test
    @Step("второй тест")
    public void testFactorial() {
        assertEquals(1, BezrukihClass.factorials(0));
        assertEquals(1, BezrukihClass.factorials(1));
        assertEquals(2, BezrukihClass.factorials(2));
        assertEquals(6, BezrukihClass.factorials(3));
        assertEquals(24, BezrukihClass.factorials(4));
        assertEquals(120, BezrukihClass.factorials(5));
    }
    @Test
    @Step("третий тест")
    @TmsLink("TestCase-112")
    @Issue("BUG-985")
    public void testFactorialNegativeNumber() {
        try {
            BezrukihClass.factorials(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("n must be non-negative", e.getMessage());
        }
    }
}
