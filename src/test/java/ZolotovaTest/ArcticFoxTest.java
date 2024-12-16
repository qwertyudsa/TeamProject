package ZolotovaTest;

import allclasses.zolotova.ArcticFox;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArcticFoxTest {

    @Test
    public void testDefaultName() {
        ArcticFox fox = new ArcticFox();
        Assert.assertEquals("Безымянный писец", getFieldValue(fox, "name"));
    }

    @Test
    public void testDefaultAge() {
        ArcticFox fox = new ArcticFox();
        Assert.assertEquals(3, getFieldValue(fox, "age"));
    }

    @Test
    public void testDefaultWeight() {
        ArcticFox fox = new ArcticFox();
        Assert.assertEquals(4.5, (Double) getFieldValue(fox, "weight"), 0.01);
    }

    @Test
    public void testDefaultSnowTracksLeft() {
        ArcticFox fox = new ArcticFox();
        Assert.assertEquals(0, getFieldValue(fox, "snowTracksLeft"));
    }

    @Test
    public void testParameterizedName() {
        ArcticFox fox = new ArcticFox("Полярник", 5, 6.2, 50);
        Assert.assertEquals("Полярник", getFieldValue(fox, "name"));
    }

    @Test
    public void testParameterizedAge() {
        ArcticFox fox = new ArcticFox("Полярник", 5, 6.2, 50);
        Assert.assertEquals(5, getFieldValue(fox, "age"));
    }

    @Test
    public void testParameterizedWeight() {
        ArcticFox fox = new ArcticFox("Полярник", 5, 6.2, 50);
        Assert.assertEquals(6.2, (Double) getFieldValue(fox, "weight"), 0.01);
    }

    @Test
    public void testParameterizedSnowTracksLeft() {
        ArcticFox fox = new ArcticFox("Полярник", 5, 6.2, 50);
        Assert.assertEquals(50, getFieldValue(fox, "snowTracksLeft"));
    }

    @Test
    public void testLeaveTracks() {
        ArcticFox fox = new ArcticFox();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        fox.leaveTracks();

        String output = outContent.toString().trim();
        Assert.assertTrue(output.contains("оставил"));
        Assert.assertTrue(output.matches(".*\\d+ следов на снегу\\."));
    }

    @Test
    public void testPrintCharacteristics() {
        ArcticFox fox = new ArcticFox("Полярник", 5, 6.2, 50);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        fox.printCharacteristics();

        String output = outContent.toString().trim();
        Assert.assertTrue(output.contains("Имя: Полярник"));
        Assert.assertTrue(output.contains("Возраст: 5 лет"));
        Assert.assertTrue(output.contains("Вес: 6.2 кг"));
        Assert.assertTrue(output.contains("Следы на снегу: 50"));
    }

    // Вспомогательный метод для доступа к приватным полям через reflection
    private Object getFieldValue(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
