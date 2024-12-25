package smirnovaTest;

import allclasses.smirnova.Seal;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class SealTest {

    @Test
    @DisplayName("Проверка стандартного заполнения класса")
    @Description("Этот тест проверяет, что стандартный конструктор класса Seal инициализирует поля корректными значениями по умолчанию.")
    @TmsLink("TestCase-112")
    @Issue("BUG-985")
    public void testSealDefaultConstructor() {
        Seal seal = new Seal();
        Assert.assertEquals("Крошик", getFieldValue(seal, "name"));
        Assert.assertEquals(0, getFieldValue(seal, "age"));
        Assert.assertEquals(1, getFieldValue(seal, "daily_naps"));
        Assert.assertEquals(0.0, (double) getFieldValue(seal, "weight"), 0.01);
    }

    @Test
    @DisplayName("Проверка параметризованного конструктора")
    @Description("Этот тест проверяет, что параметры конструктора корректно инициализируют объект Seal.")
    public void testSealParameterizedConstructor() {
        Seal seal = new Seal("Ластик", 5, 2, 20.0);
        Assert.assertEquals("Ластик", getFieldValue(seal, "name"));
        Assert.assertEquals(5, getFieldValue(seal, "age"));
        Assert.assertEquals(1, getFieldValue(seal, "daily_naps")); // Default value for daily_naps
        Assert.assertEquals(20.0, (double) getFieldValue(seal, "weight"), 0.01);
    }

    @Test
    @DisplayName("Проверка поведения метода triks() при нулевом возрасте")
    @Description("Этот тест проверяет, что метод triks() корректно выводит сообщение о том, что детёныш тюленя слишком мал для выполнения трюков.")
    public void testTriksWithAgeZero() {
        Seal seal = new Seal("Крошик", 0, 1, 10.0);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        seal.triks();

        String expectedOutput = "Крошик слишком маленький, чтобы делать трюки.";
        Assert.assertTrue(outContent.toString().trim().contains(expectedOutput));
    }

    @Test
    @DisplayName("Проверка поведения метода triks() при положительном возрасте")
    @Description("Этот тест проверяет, что метод triks() выводит корректные трюки для тюленя с положительным возрастом.")
    public void testTriksWithPositiveAge() {
        Seal seal = initializeSeal("Крошик", 3, 1, 15.0);
        ByteArrayOutputStream outContent = captureSystemOutput();

        executeTricks(seal);

        String output = getCapturedOutput(outContent);

        verifyOutputContains(output, "Крошик сегодня празднует день рождения!");
        verifyOutputContains(output, "Трюк 1");
        verifyOutputContains(output, "Трюк 2");
        verifyOutputContains(output, "Трюк 3");
    }

    @Step("Инициализация объекта Seal с параметрами: name={0}, age={1}, dailyNaps={2}, weight={3}")
    private Seal initializeSeal(String name, int age, int dailyNaps, double weight) {
        return new Seal(name, age, dailyNaps, weight);
    }

    @Step("Перенаправление System.out в ByteArrayOutputStream для перехвата вывода")
    private ByteArrayOutputStream captureSystemOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @Step("Выполнение метода triks() для объекта Seal")
    private void executeTricks(Seal seal) {
        seal.triks();
    }

    @Step("Получение захваченного вывода")
    private String getCapturedOutput(ByteArrayOutputStream outContent) {
        return outContent.toString().trim();
    }

    @Step("Проверка, что вывод содержит строку: {1}")
    private void verifyOutputContains(String output, String expectedSubstring) {
        Assert.assertTrue("Ожидаемая строка отсутствует в выводе: " + expectedSubstring,
                output.contains(expectedSubstring));
    }

    private Object getFieldValue(Object obj, String fieldName) {
        try {
            var field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}