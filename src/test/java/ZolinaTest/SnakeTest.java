package ZolinaTest;

import allclasses.zolina.Snake;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SnakeTest {

    @Test
    @DisplayName("Проверка на создание змеи")
    @Description("Змея создается с определенным типом")
    @TmsLink("TMS-1234")
    @Issue("BUG-1001")
    public void testSnakeDefaultKind() {
        Snake snake = createDefaultSnake();
        verifyFieldValue(snake, "kind", "Удав");
    }

    @Test
    @DisplayName("Проверка на возраст")
    @Description("Змея создается с определенным возрастом")
    @TmsLink("TMS-1235")
    public void testSnakeDefaultAge() {
        Snake snake = createDefaultSnake();
        verifyFieldValue(snake, "age", 2);
    }

    @Test
    @DisplayName("Проверка на задание длины змее")
    @Description("Змея создается с определенной длиной")
    @TmsLink("TMS-1236")
    public void testSnakeDefaultLength() {
        Snake snake = createDefaultSnake();
        verifyFieldValue(snake, "length", 60);
    }

    @Test
    @DisplayName("Проверка на яблоки")
    @Description("Змея создается с определенным количеством яблок, скормленных Евой")
    @TmsLink("TMS-1237")
    public void testSnakeDefaultApple() {
        Snake snake = createDefaultSnake();
        verifyFieldValue(snake, "apple", 1);
    }

    @Test
    @DisplayName("Проверка на создание змеи с полными параметрами")
    @Description("Змея создается с определенным типом, возрастом, длиной и количеством яблок")
    @TmsLink("TMS-1238")
    @Issue("BUG-1002")
    public void testSnakeParameterizedKind() {
        Snake snake = createSnakeWithParams("Кобра", 5, 150, 3);
        verifyFieldValue(snake, "kind", "Кобра");
    }

    @Test
    @DisplayName("Проверка возраста у параметризованной змеи")
    @Description("Создается змея и проверяется ее возраст")
    @TmsLink("TMS-1239")
    public void testSnakeParameterizedAge() {
        Snake snake = createSnakeWithParams("Кобра", 5, 150, 3);
        verifyFieldValue(snake, "age", 5);
    }

    @Test
    @DisplayName("Проверка длины у параметризованной змеи")
    @Description("Создается змея и проверяется ее длина")
    @TmsLink("TMS-1240")
    public void testSnakeParameterizedLength() {
        Snake snake = createSnakeWithParams("Кобра", 5, 150, 3);
        verifyFieldValue(snake, "length", 150);
    }

    @Test
    @DisplayName("Проверка количества яблок у параметризованной змеи")
    @Description("Создается змея и проверяется количество яблок")
    @TmsLink("TMS-1241")
    public void testSnakeParameterizedApple() {
        Snake snake = createSnakeWithParams("Кобра", 5, 150, 3);
        verifyFieldValue(snake, "apple", 3);
    }

    @Test
    @DisplayName("Проверка метода hiss")
    @Description("Выводится звук шипения змеи через метод hiss()")
    @TmsLink("TMS-1242")
    @Issue("BUG-1003")
    public void testHissMethod() {
        Snake snake = createSnakeWithParams("Кобра", 3, 100, 0);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        executeHissMethod(snake);

        Assert.assertTrue(outContent.toString().trim().contains("ШшшшААА..."));
    }

    // Шаги для тестов
    @Step("Создание змеи со значениями по умолчанию")
    private Snake createDefaultSnake() {
        return new Snake();
    }

    @Step("Создание змеи с параметрами: тип={kind}, возраст={age}, длина={length}, яблоки={apple}")
    private Snake createSnakeWithParams(String kind, int age, int length, int apple) {
        return new Snake(kind, age, length, apple);
    }

    @Step("Проверка значения поля {fieldName}: ожидаемое значение = {expected}")
    private void verifyFieldValue(Object obj, String fieldName, Object expected) {
        Assert.assertEquals(expected, getFieldValue(obj, fieldName));
    }

    @Step("Выполнение метода hiss()")
    private void executeHissMethod(Snake snake) {
        snake.hiss();
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
