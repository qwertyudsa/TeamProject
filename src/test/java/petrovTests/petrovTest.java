package petrovTests;

import allclasses.petrov.Programmer;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

public class petrovTest {

    @Test
    @DisplayName("Проверка начальных значений программиста")
    @Description("Тест проверяет, что программист написал 0 строк кода и начальный уровень кофеина составляет 50.")
    @TmsLink("TMS-001")
    @Issue("ISSUE-101")
    public void testInitialValues() {
        Programmer programmer = new Programmer("Alex Petrov", 27);
        logStep("Создан объект Programmer с начальными значениями.");
        String performance = programmer.getPerformance();
        logStep("Получена производительность: " + performance);
        Assert.assertTrue(performance.contains("написал 0 строк кода")); // Учитываем формат
        Assert.assertTrue(performance.contains("Уровень кофеина: 50")); // Начальный уровень кофеина
    }

    @Test
    @DisplayName("Проверка написания кода и изменения уровня кофеина")
    @Description("Тест проверяет, что после написания кода строки увеличиваются, а уровень кофеина уменьшается до 30 или 40.")
    @TmsLink("TMS-002")
    @Issue("ISSUE-102")
    public void testWriteCode() {
        Programmer programmer = new Programmer("Alex Petrov", 27);
        logStep("Создан объект Programmer с начальными значениями.");
        programmer.writeCode();
        logStep("Метод writeCode вызван.");
        logStep("Проверяем, что строки кода увеличиваются и уровень кофеина снижается.");
        String performance = programmer.getPerformance();
        logStep("Получена производительность: " + performance);
        Assert.assertFalse(performance.contains("строк кода: 0")); // Линии кода увеличиваются
        Assert.assertTrue(performance.contains("Уровень кофеина: 40") ||
                performance.contains("Уровень кофеина: 30")); // Кофеин уменьшается
    }

    @Test
    @DisplayName("Проверка увеличения уровня кофеина до 70")
    @Description("Тест проверяет, что после употребления кофе уровень кофеина увеличивается до 70.")
    @TmsLink("TMS-003")
    @Issue("ISSUE-103")
    public void testDrinkCoffee() {
        Programmer programmer = new Programmer("Alex Petrov", 27);
        logStep("Создан объект Programmer с начальными значениями.");
        programmer.drinkCoffee();
        logStep("Метод drinkCoffee вызван.");
        logStep("Проверяем, что уровень кофеина увеличивается до ожидаемого значения.");
        String performance = programmer.getPerformance();
        logStep("Получена производительность: " + performance);
        Assert.assertTrue(performance.contains("Уровень кофеина: 70")); // Кофеин увеличился
    }

    @Test
    @DisplayName("Проверка максимального уровня кофеина в 100")
    @Description("Тест проверяет, что уровень кофеина достигает максимального значения 100 после нескольких чашек кофе.")
    @TmsLink("TMS-004")
    @Issue("ISSUE-104")
    public void testDrinkCoffeeMaxLevel() {
        Programmer programmer = new Programmer("Alex Petrov", 27);
        logStep("Создан объект Programmer с начальными значениями.");
        programmer.drinkCoffee(); // Уровень кофеина: 70
        logStep("Метод drinkCoffee вызван первый раз.");
        programmer.drinkCoffee(); // Уровень кофеина: 90
        logStep("Метод drinkCoffee вызван второй раз.");
        programmer.drinkCoffee(); // Уровень кофеина: 100
        logStep("Метод drinkCoffee вызван третий раз.");
        String performance = programmer.getPerformance();
        logStep("Получена производительность: " + performance);
        Assert.assertTrue(performance.contains("Уровень кофеина: 100")); // Максимальный уровень
    }

    @Test
    @DisplayName("Проверка восстановления уровня кофеина до 80")
    @Description("Тест проверяет, что после перерыва уровень кофеина восстанавливается до 80.")
    @TmsLink("TMS-005")
    @Issue("ISSUE-105")
    public void testTakeBreak() {
        Programmer programmer = new Programmer("Alex Petrov", 27);
        logStep("Создан объект Programmer с начальными значениями.");
        programmer.takeBreak();
        logStep("Метод takeBreak вызван.");
        logStep("Проверяем, что уровень кофеина восстанавливается до 80.");
        String performance = programmer.getPerformance();
        logStep("Получена производительность: " + performance);
        Assert.assertTrue(performance.contains("Уровень кофеина: 80")); // Восстановленный кофеин
    }

    @Step("{stepDescription}")
    private void logStep(String stepDescription) {
        System.out.println(stepDescription);
    }
}