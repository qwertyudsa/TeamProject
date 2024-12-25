package SavinskayaTest;

import allclasses.Savinskaya.Something;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests{

    @Test
    @DisplayName("Equilateral Triangle Test")
    @Issue("TRIANGLE-001")
    @TmsLink("TestCase-10.1")
    @Description("Tests an equilateral triangle with sides of equal length")
    public void testEquilateralTriangle() {
        Something triangle = new Something(5, 5, 5);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Equilateral", triangle.getType());
        assertEquals(15.0, triangle.getPerimeter(), 0.0001);
        assertEquals(10.825317547305483, triangle.getArea(), 0.0001);
    }

    @Test
    @DisplayName("Isosceles Triangle Test")
    @Issue("TRIANGLE-002")
    @TmsLink("TestCase-10.2")
    @Description("Tests an isosceles triangle with two equal sides and one differing side")
    public void testIsoscelesTriangle() {
        Something triangle = new Something(5, 5, 7);
        assertEquals("Isosceles", triangle.getType());
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals(17.0, triangle.getPerimeter(), 0.0001);
        assertEquals(12.497499749949988, triangle.getArea(), 0.0001); // Updated value
    }

    @Test
    @DisplayName("Scalene Triangle Test")
    @Issue("TRIANGLE-003")
    @TmsLink("TestCase-10.3")
    @Description("Tests a scalene triangle with all sides of differing lengths")
    public void testScaleneTriangle() {
        Something triangle = new Something(3, 4, 5);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Scalene", triangle.getType());
        assertEquals(12.0, triangle.getPerimeter(), 0.0001);
        assertEquals(6.0, triangle.getArea(), 0.0001);
    }

    @Test
    @DisplayName("Invalid Triangle Test - Sides do not form a triangle")
    @Issue("TRIANGLE-004")
    @TmsLink("TestCase-10.4")
    @Description("Tests a triangle where one side is too long to form a valid triangle")
    public void testInvalidTriangle1() {
        Something triangle = new Something(1, 1, 3);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Invalid triangle", triangle.getType());
    }
    @Step ("Шаг первый")
    public void methodForStepOne(){
        System.out.println("Вызов метода шага 1");
    }
    @Step ("Шаг второй")
    public void methodForStepTwo(){
        System.out.println("Вызов метода шага 2");
    }
    @Step ("Шаг третий")
    public void methodForStepThree(){
        System.out.println("Вызов метода шага 3");
    }
    @Test
    @DisplayName("Invalid Triangle Test - Negative side length")
    @Issue("TRIANGLE-005")
    @TmsLink("TestCase-10.5")
    @Description("Tests a triangle with a negative side length")
    public void testInvalidTriangle2() {

        Something triangle = new Something(-1, 2, 3);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Invalid triangle", triangle.getType());
    }


    @Test
    @DisplayName("Invalid Triangle Test - Zero side length")
    @Issue("TRIANGLE-006")
    @TmsLink("TestCase-10.6")
    @Description("Tests a triangle with a side length of zero")
    public void testInvalidTriangle3() {
        Something triangle = new Something(0, 2, 3);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Invalid triangle", triangle.getType());
    }

    @Test
    @DisplayName("Invalid Triangle Test - All sides are zero")
    @Issue("TRIANGLE-007")
    @TmsLink("TestCase-10.7")
    @Description("Tests a triangle where all sides have a length of zero")
    public void testZeroSides() {
        Something triangle = new Something(0, 0, 0);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Invalid triangle", triangle.getType());
    }

    @Test
    @DisplayName("Large Equilateral Triangle Test")
    @Issue("TRIANGLE-008")
    @TmsLink("TestCase-10.8")
    @Description("Tests a large equilateral triangle with sides of 1000 units")
    public void testLargeTriangle() {
        Something triangle = new Something(1000, 1000, 1000);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals("Equilateral", triangle.getType());
        assertEquals(3000.0, triangle.getPerimeter(), 0.0001);
        assertEquals(433012.7018922193, triangle.getArea(), 0.001);
    }
}
