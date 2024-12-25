package stebunov;

import allclasses.stebunov.Wolf;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import io.qameta.allure.Description; // импорт Description
import io.qameta.allure.Step; // импорт Step
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;

public class WolfTests {

    @Test
    @DisplayName("Тест установки возраста и веса волка")
    @Description("Проверка корректной установки возраста и веса волка при использовании конструктора по умолчанию")
    @TmsLink("TestCase-112") // Ссылка на тест кейс
    @Issue("BUG-985") // Ссылка на баг репорт
    public void testMethodOne() throws Exception{
        Wolf wolf = new Wolf();
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        wolf.setAge(4);
        wolf.setWeight(34.5);
        assertEquals("Безымянный", wolf.getName());
        assertEquals(4, wolf.getAge());
        assertEquals(34.5, wolf.getWeight(), 0.01);
    }

    @Step("Шаг первый")
    private void methodForStepOne() {
        System.out.println("Вызов метода шага 1");
    }
    @Step("Шаг второй")
    private void methodForStepTwo() {
        System.out.println("Вызов метода шага 2");
    }
    @Step("Шаг третий")
    private void methodForStepThree() {
        System.out.println("Вызов метода шага 3");
    }

    // Тест конструктора по умолчанию
    @Test
    @DisplayName("Тест конструктора по умолчанию")
    @Description("Проверка значений по умолчанию для имени, возраста и веса")
    public void testDefaultConstructor() {
        Wolf wolf = new Wolf();
        assertEquals("Безымянный", wolf.getName());
        assertEquals(0, wolf.getAge());
        assertEquals(0.0, wolf.getWeight(), 0.01);
    }

    // Тест конструктора с параметрами
    @Test
    @DisplayName("Тест конструктора с параметрами")
    @Description("Проверка инициализации объекта с заданными параметрами")
    public void testParameterizedConstructor() {
        Wolf wolf = new Wolf("Серый", 5, 40.5);
        assertEquals("Серый", wolf.getName());
        assertEquals(5, wolf.getAge());
        assertEquals(40.5, wolf.getWeight(), 0.01);
    }

    // Тест метода setName
    @Test
    @DisplayName("Тест метода setName")
    @Description("Проверка установки имени волка")
    public void testSetName() {
        Wolf wolf = new Wolf();
        wolf.setName("Белый");
        assertEquals("Белый", wolf.getName());
    }

    // Тест метода setAge с корректным значением
    @Test
    @DisplayName("Тест метода setAge с корректным значением")
    @Description("Проверка установки корректного возраста волка")
    public void testSetAgeCorrect() {
        Wolf wolf = new Wolf();
        wolf.setAge(3);
        assertEquals(3, wolf.getAge());
    }

    // Тест метода setAge с некорректным значением (отрицательный возраст)
    @Test
    @DisplayName("Тест метода setAge с некорректным значением (отрицательный возраст)")
    @Description("Проверка обработки отрицательного значения возраста")
    public void testSetAgeIncorrect() {
        Wolf wolf = new Wolf();
        wolf.setAge(-5); // Должно вывести сообщение об ошибке, но не изменить значение
        assertEquals(0, wolf.getAge());
    }

    // Тест метода setWeight с корректным значением
    @Test
    @DisplayName("Тест метода setWeight с корректным значением")
    @Description("Проверка установки корректного веса волка")
    public void testSetWeightCorrect() {
        Wolf wolf = new Wolf();
        wolf.setWeight(30.5);
        assertEquals(30.5, wolf.getWeight(), 0.01);
    }

    // Тест метода setWeight с некорректным значением (отрицательный вес)
    @Test
    @DisplayName("Тест метода setWeight с некорректным значением (отрицательный вес)")
    @Description("Проверка обработки отрицательного значения веса")
    public void testSetWeightIncorrect() {
        Wolf wolf = new Wolf();
        wolf.setWeight(-10); // Должно вывести сообщение об ошибке, но не изменить значение
        assertEquals(0.0, wolf.getWeight(), 0.01);
    }

    // Тест метода howl
    @Test
    @DisplayName("Тест метода howl")
    @Description("Проверка, что волк умеет выть")
    public void testHowl() {
        Wolf wolf = new Wolf("Серый", 5, 25.5);
        assertEquals("Волк Серый воет: Аууууу!", wolf.howl());
    }
}