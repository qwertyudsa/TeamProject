package HrustaliovaTests;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import io.qameta.allure.Description; // импорт Description
import allclasses.hrustaliova.Rat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

public class RatsTests {

    @Test
    @DisplayName("Проверка конструктора Rat")
    @Description("Тестирует создание объекта Rat с заданными именем и весом.")
    @TmsLink("TestCase-112")
    @Issue("BUG-985")
    public void testRatConstructor() {
        createRat("TestRat", 100);
    }
    @Step("Создание крысы с именем {name} и весом {weight}")
    private Rat createRat(String name, int weight) {
        Rat rat = new Rat(name, weight);
        assertEquals(name, rat.getName());
        assertEquals(weight, rat.getWeight());
        assertTrue(rat.isHungry()); // Крыса должна быть голодной после создания
        return rat;
    }

    @Test
    @DisplayName("Проверка метода кормления крысы")
    @Description("Тестирует метод кормления крысы и проверяет изменение веса и состояние голода.")
    public void testRatFeed() {
        Rat rat = createRat("TestRat", 100);
        feedRat(rat, 50);
    }

    @Step("Кормление крысы {rat} на {amount} единиц")
    private void feedRat(Rat rat, int amount) {
        rat.feed(amount);
        assertEquals(100 + amount, rat.getWeight());
        assertFalse(rat.isHungry()); // Крыса не должна быть голодной после кормления
    }

    @Test
    @DisplayName("Проверка метода кормления крысы отрицательным количеством")
    @Description("Тестирует метод кормления крысы отрицательным количеством и проверяет, что вес не изменяется.")
    public void testRatFeedNegativeAmount() {
        Rat rat = createRat("TestRat", 100);
        feedRatNegativeAmount(rat, -50);
    }

    @Step("Кормление крысы {rat} отрицательным количеством {amount}")
    private void feedRatNegativeAmount(Rat rat, int amount) {
        rat.feed(amount); // Попытка накормить отрицательным количеством
        assertEquals(100, rat.getWeight()); // Вес не должен измениться
        assertTrue(rat.isHungry()); // Крыса остается голодной
    }

    @Test
    @DisplayName("Проверка установки положительного веса Rat")
    @Description("Тестирует установку положительного веса крысы.")
    public void testRatSetWeightPositive() {
        Rat rat = createRat("TestRat", 100);
        setWeight(rat, 150);
    }

    @Step("Установка веса крысы {rat} на {weight}")
    private void setWeight(Rat rat, int weight) {
        rat.setWeight(weight);
        assertEquals(weight, rat.getWeight());
    }

    @Test
    @DisplayName("Проверка установки отрицательного веса Rat")
    @Description("Тестирует попытку установить отрицательный вес крысы и проверяет, что вес не изменяется.")
    public void testRatSetWeightNegative() {
        Rat rat = createRat("TestRat", 100);
        setWeightNegative(rat, -50);
    }

    @Step("Попытка установить отрицательный вес крысы {rat} на {weight}")
    private void setWeightNegative(Rat rat, int weight) {
        rat.setWeight(weight); // Попытка установить отрицательный вес
        assertEquals(100, rat.getWeight()); // Вес не должен измениться
    }

    @Test
    @DisplayName("Проверка метода describe()")
    @Description("Тестирует метод describe() и проверяет корректность строкового описания крысы.")
    public void testRatDescribe() {
        Rat rat = createRat("TestRat", 100);
        describeRat(rat);
    }

    @Step("Проверка описания крысы {rat}")
    private void describeRat(Rat rat) {
        assertEquals("Имя: TestRat, Вес: 100, Голодная: true", rat.describe());
        rat.feed(50);
        assertEquals("Имя: TestRat, Вес: 150, Голодная: false", rat.describe());
    }

    @Test
    @DisplayName("Проверка метода getName()")
    @Description("Тестирует метод получения имени крысы.")
    public void testRatGetName() {
        Rat rat = createRat("TestRat", 100);
        getName(rat);
    }

    @Step("Получение имени крысы {rat}")
    private void getName(Rat rat) {
        assertEquals("TestRat", rat.getName());
    }

    @Test
    @DisplayName("Проверка метода setName()")
    @Description("Тестирует метод установки имени крысы.")
    public void testRatSetName() {
        Rat rat = createRat("TestRat", 100);
        setName(rat, "NewName");
    }

    @Step("Установка имени крысы {rat} на {newName}")
    private void setName(Rat rat, String newName) {
        rat.setName(newName);
        assertEquals(newName, rat.getName());
    }
}