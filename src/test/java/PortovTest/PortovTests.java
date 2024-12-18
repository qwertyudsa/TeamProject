package PortovTest;

import allclasses.Portov.Person;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;

import static org.junit.Assert.assertEquals;

public class PortovTests {

    @Test
    @DisplayName("Проверка, что у нас правильный вывод приветствия")
    @Description("Этот тест проверяет корректность вывода приветственной строки для объекта Person.")
    @TmsLink("TMS-123")
    @Issue("BUG-456")
    public void testIntroduce() {
        logStep("Создаём объект Person с именем 'Алексей' и возрастом 25");
        Person person = createPerson("Алексей", 25);

        String expected = "Привет, меня зовут Алексей, мне 25 лет.";
        logStep("Проверяем корректность возвращаемой строки");
        assertEquals(expected, person.introduce());
    }

    @Test
    @DisplayName("Проверка, что у нас корректно изменился возраст")
    @Description("Этот тест проверяет корректность изменения возраста объекта Person после вызова метода haveBirthday().")
    @TmsLink("TMS-124")
    @Issue("BUG-457")
    public void testHaveBirthday() {
        logStep("Создаём объект Person с именем 'Алексей' и возрастом 25");
        Person person = createPerson("Алексей", 25);

        logStep("Вызываем метод haveBirthday(), увеличивающий возраст на 1");
        person.haveBirthday();

        logStep("Проверяем, что возраст увеличился на 1");
        assertEquals(26, person.getAge());
    }

    @Test
    @DisplayName("Проверка, что у нас правильный вывод приветствия")
    @Description("Этот тест проверяет корректность изменения возраста после нескольких вызовов метода haveBirthday().")
    @TmsLink("TMS-125")
    @Issue("BUG-458")
    public void testMultipleBirthdays() {
        logStep("Создаём объект Person с именем 'Алексей' и возрастом 25");
        Person person = createPerson("Алексей", 25);

        logStep("Первый вызов метода haveBirthday()");
        person.haveBirthday();

        logStep("Второй вызов метода haveBirthday()");
        person.haveBirthday();

        logStep("Третий вызов метода haveBirthday()");
        person.haveBirthday();

        logStep("Проверяем, что возраст увеличился на 3");
        assertEquals(28, person.getAge());
    }

    @Step("Создание объекта Person с именем '{0}' и возрастом {1}")
    private Person createPerson(String name, int age) {
        logStep("Инициализация объекта Person");
        Person person = new Person(name, age);
        logStep("Объект Person с именем '" + name + "' и возрастом " + age + " успешно создан");
        return person;
    }

    @Step("{0}")
    private void logStep(String stepDescription) {
        System.out.println(stepDescription);
    }
}
