package SavinskayaTest;

import allclasses.Savinskaya.Something;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavinskayaTest {

    @Test
    @DisplayName("Equilateral Triangle Test")
    @Issue("TRIANGLE-001")
    @Description("Tests an equilateral triangle with sides of equal length")
    public void testEquilateralTriangle() {
        Something triangle = new Something(5, 5, 5);
        assertEquals("Equilateral", triangle.getType());
        assertEquals(15.0, triangle.getPerimeter(), 0.0001);
        assertEquals(10.825317547305483, triangle.getArea(), 0.0001);
    }

    @Test
    @DisplayName("Isosceles Triangle Test")
    @Issue("TRIANGLE-002")
    @Description("Tests an isosceles triangle with two equal sides and one differing side")
    public void testIsoscelesTriangle() {
        Something triangle = new Something(5, 5, 7);
        assertEquals("Isosceles", triangle.getType());
        assertEquals(17.0, triangle.getPerimeter(), 0.0001);
        assertEquals(12.497499749949988, triangle.getArea(), 0.0001); // Updated value
    }

    @Test
    @DisplayName("Scalene Triangle Test")
    @Issue("TRIANGLE-003")
    @Description("Tests a scalene triangle with all sides of differing lengths")
    public void testScaleneTriangle() {
        Something triangle = new Something(3, 4, 5);
        assertEquals("Scalene", triangle.getType());
        assertEquals(12.0, triangle.getPerimeter(), 0.0001);
        assertEquals(6.0, triangle.getArea(), 0.0001);
    }

    @Test
    @DisplayName("Invalid Triangle Test - Sides do not form a triangle")
    @Issue("TRIANGLE-004")
    @Description("Tests a triangle where one side is too long to form a valid triangle")
    public void testInvalidTriangle1() {
        Something triangle = new Something(1, 1, 3);
        assertEquals("Invalid triangle", triangle.getType());
    }

    @Test
    @DisplayName("Invalid Triangle Test - Negative side length")
    @Issue("TRIANGLE-005")
    @Description("Tests a triangle with a negative side length")
    public void testInvalidTriangle2() {
        Something triangle = new Something(-1, 2, 3);
        assertEquals("Invalid triangle", triangle.getType());
    }

    @Test
    @DisplayName("Invalid Triangle Test - Zero side length")
    @Issue("TRIANGLE-006")
    @Description("Tests a triangle with a side length of zero")
    public void testInvalidTriangle3() {
        Something triangle = new Something(0, 2, 3);
        assertEquals("Invalid triangle", triangle.getType());
    }

    @Test
    @DisplayName("Invalid Triangle Test - All sides are zero")
    @Issue("TRIANGLE-007")
    @Description("Tests a triangle where all sides have a length of zero")
    public void testZeroSides() {
        Something triangle = new Something(0, 0, 0);
        assertEquals("Invalid triangle", triangle.getType());
    }

    @Test
    @DisplayName("Large Equilateral Triangle Test")
    @Issue("TRIANGLE-008")
    @Description("Tests a large equilateral triangle with sides of 1000 units")
    public void testLargeTriangle() {
        Something triangle = new Something(1000, 1000, 1000);
        assertEquals("Equilateral", triangle.getType());
        assertEquals(3000.0, triangle.getPerimeter(), 0.0001);
        assertEquals(433012.7018922193, triangle.getArea(), 0.001);
    }
}