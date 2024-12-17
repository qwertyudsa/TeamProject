import allclasses.Savinskaya.Something;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

   package SavinskayaTest;

   import allclasses.Savinskaya.Something;
   import org.junit.Test;

   import static org.junit.Assert.assertEquals;
   import static org.junit.Assert.assertTrue;

   public class SavinskayaTest {

       @Test
       public void testEquilateralTriangle() {
           Something triangle = new Something(5, 5, 5);
           assertEquals("Equilateral", triangle.getType());
           assertEquals(15.0, triangle.getPerimeter(), 0.0001);
           assertEquals(10.825317547305483, triangle.getArea(), 0.0001);
       }

       @Test
       public void testIsoscelesTriangle() {
           Something triangle = new Something(5, 5, 7);
           assertEquals("Isosceles", triangle.getType());
           assertEquals(17.0, triangle.getPerimeter(), 0.0001);
           assertEquals(12.497499749949988, triangle.getArea(), 0.0001); // Обновленное значение
       }
       @Test
       public void testScaleneTriangle() {
           Something triangle = new Something(3, 4, 5);
           assertEquals("Scalene", triangle.getType());
           assertEquals(12.0, triangle.getPerimeter(), 0.0001);
           assertEquals(6.0, triangle.getArea(), 0.0001);
       }

       @Test
       public void testInvalidTriangle1() {
           Something triangle = new Something(1, 1, 3);
           assertEquals("Invalid triangle", triangle.getType());
       }

       @Test
       public void testInvalidTriangle2() {
           Something triangle = new Something(-1, 2, 3);
           assertEquals("Invalid triangle", triangle.getType());
       }

       @Test
       public void testInvalidTriangle3() {
           Something triangle = new Something(0, 2, 3);
           assertEquals("Invalid triangle", triangle.getType());
       }

       @Test
       public void testZeroSides() {
           Something triangle = new Something(0, 0, 0);
           assertEquals("Invalid triangle", triangle.getType());
       }

       @Test
       public void testLargeTriangle() {
           Something triangle = new Something(1000, 1000, 1000);
           assertEquals("Equilateral", triangle.getType());
           assertEquals(3000.0, triangle.getPerimeter(), 0.0001);
           assertEquals(433012.7018922193, triangle.getArea(), 0.001);
       }
   }
