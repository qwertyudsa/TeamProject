package StrelnikovTests;

import allclasses.strelnikov.Capybara;
import org.junit.Test;
import static org.junit.Assert.*;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;

public class StrelnikovTests {

    @Test
    @TmsLink("TMS-101")
    @DisplayName("Конструктор должен корректно инициализировать имя капибары")
    @Description("Проверяет, что конструктор корректно устанавливает имя капибары с использованием геттера.")
    public void testConstructorInitializesFields() {
        Capybara capy = createCapybara("Каппи", 3, 35.5);
        verifyName(capy, "Каппи");
    }

    @Test
    @TmsLink("TMS-102")
    @DisplayName("Метод eat должен увеличивать вес капибары")
    @Description("Проверяет, что метод eat корректно прибавляет вес к текущему значению веса капибары.")
    public void testEatIncreasesWeight() {
        Capybara capy = createCapybara("Каппи", 3, 35.5);
        eatFood(capy, 2.0);
        verifyWeight(capy, 37.5);
    }

    @Test
    @TmsLink("TMS-103")
    @DisplayName("Метод play должен уменьшать вес капибары")
    @Description("Проверяет, что метод play корректно уменьшает вес капибары после расхода энергии.")
    public void testPlayDecreasesWeight() {
        Capybara capy = createCapybara("Каппи", 3, 35.5);
        playWithEnergy(capy, 1.5);
        verifyWeight(capy, 34.0);
    }

    @Test
    @TmsLink("TMS-104")
    @DisplayName("Метод growOlder должен увеличивать возраст капибары")
    @Description("Проверяет, что метод growOlder корректно увеличивает возраст капибары на 1 год.")
    public void testGrowOlderIncreasesAge() {
        Capybara capy = createCapybara("Каппи", 3, 35.5);
        makeOlder(capy);
        verifyAge(capy, 4);
    }

    @Test
    @TmsLink("TMS-105")
    @Issue("ISSUE-456")
    @DisplayName("Метод speak должен выводить сообщение в консоль")
    @Description("Проверяет корректность сообщения, которое выводится в консоль при вызове метода speak.")
    public void testSpeakOutput() {
        Capybara capy = createCapybara("Каппи", 3, 35.5);
        String expectedMessage = "Каппи говорит: Хрю-хрю!";
        verifyOutput(capy::speak, expectedMessage);
    }

    @Test
    @TmsLink("TMS-106")
    @Issue("ISSUE-789")
    @DisplayName("Метод swim должен выводить сообщение о плавании")
    @Description("Проверяет корректность сообщения, которое выводится в консоль при вызове метода swim.")
    public void testSwimOutput() {
        Capybara capy = createCapybara("Каппи", 3, 35.5);
        String expectedMessage = "Каппи плавает в озере. Это ее любимое занятие!";
        verifyOutput(capy::swim, expectedMessage);
    }

    // ------------------- Шаги для тестов -------------------

    @Step("Создаем капибару с именем {name}, возрастом {age} и весом {weight}")
    private Capybara createCapybara(String name, int age, double weight) {
        return new Capybara(name, age, weight);
    }

    @Step("Проверяем, что имя капибары равно {expectedName}")
    private void verifyName(Capybara capy, String expectedName) {
        assertEquals(expectedName, capy.getName());
    }

    @Step("Кормим капибару, добавляя {foodWeight} кг еды")
    private void eatFood(Capybara capy, double foodWeight) {
        capy.eat(foodWeight);
    }

    @Step("Проверяем, что вес капибары равен {expectedWeight}")
    private void verifyWeight(Capybara capy, double expectedWeight) {
        assertEquals(expectedWeight, capy.getWeight(), 0.01);
    }

    @Step("Играем с капибарой, затрачивая {energySpent} энергии")
    private void playWithEnergy(Capybara capy, double energySpent) {
        capy.play(energySpent);
    }

    @Step("Увеличиваем возраст капибары на 1 год")
    private void makeOlder(Capybara capy) {
        capy.growOlder();
    }

    @Step("Проверяем, что возраст капибары равен {expectedAge}")
    private void verifyAge(Capybara capy, int expectedAge) {
        assertEquals(expectedAge, capy.getAge());
    }

    @Step("Проверяем вывод метода. Ожидаемое сообщение: {expectedMessage}")
    private void verifyOutput(Runnable method, String expectedMessage) {
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        method.run();

        assertEquals(expectedMessage, outContent.toString().trim());
    }
}
