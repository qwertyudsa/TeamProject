package yakimovichTests;

import allclasses.yakimovich.YakimovichClass;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import java.util.List;
import static org.junit.Assert.*;


public class CalculateTests {
    private YakimovichClass calculator = new YakimovichClass();

    @Test
    @DisplayName("Проверка корректного сложения двух чисел")
    @TmsLink("TestCase-111") //Ссылка на тест кейс
    @Issue("BUG-202") //Ссылка на баг-репорт
    public void testAdd() {
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(0,0));
    }

    @Step ("Шаг первый")
    public void methodForStepOne()
    {
        System.out.println("Записали первое значение");
    }

    @Step ("Шаг второй")
    public void methodForStepTwo()
    {
        System.out.println("Записали второе значение");
    }

    @Step ("Шаг третий")
    public void methodForStepThree()
    {
        System.out.println("Получили ответ");
    }

    @Test
    @DisplayName("Проверка корректной разности двух чисел")
    @TmsLink("TestCase-112") //Ссылка на тест кейс
    @Issue("BUG-203") //Ссылка на баг-репорт
    public void testSubtract() {
        assertEquals(1, calculator.subtract(4, 3));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    @DisplayName("Проверка корректного умножения двух чисел")
    @TmsLink("TestCase-113") //Ссылка на тест кейс
    @Issue("BUG-204") //Ссылка на баг-репорт
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(2, 0));
        assertEquals(0, calculator.multiply(0, 3));
    }


    @Test
    @DisplayName("Проверка корректного деления двух чисел")
    @TmsLink("TestCase-114") //Ссылка на тест кейс
    @Issue("BUG-205") //Ссылка на баг-репорт
    public void testDivide() {
        assertEquals(3.5, calculator.divide(7, 2), 0.0001);
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
    }


    @Test
    @DisplayName("Проверка, что в списке находится определенное количество четных чисел, а также что список содержит четные числа до определенного числа (включительно)")
    @TmsLink("TestCase-115") //Ссылка на тест кейс
    @Issue("BUG-206") //Ссылка на баг-репорт
    public void testGenerateEvenNumbers() {
        methodForStepOneList();
        methodForStepTwoList();
        List<Integer> evenNumbers = calculator.generateEvenNumbers(16);
        assertEquals(9, evenNumbers.size());
        assertTrue(evenNumbers.contains(0));
        assertTrue(evenNumbers.contains(2));
        assertTrue(evenNumbers.contains(6));
        assertTrue(evenNumbers.contains(8));
        assertTrue(evenNumbers.contains(14));
        assertTrue(evenNumbers.contains(16));
    }

    @Step ("Шаг первый")
    public void methodForStepOneList()
    {
        System.out.println("Генерация чисел до определенного числа включительно");
    }

    @Step ("Шаг второй")
    public void methodForStepTwoList()
    {
        System.out.println("Проверили, что в списке присутствуют четные числа");
    }

    @Test
    @DisplayName("Проверка, что в списке будет одно четное число, а также что список содержит четное число до 0 (включительно)")
    @TmsLink("TestCase-116") //Ссылка на тест кейс
    @Issue("BUG-207") //Ссылка на баг-репорт
    public void testGenerateEvenNumbersZeroInput() {
        List<Integer> evenNumbers = calculator.generateEvenNumbers(0);
        assertEquals(1, evenNumbers.size());
        assertTrue(evenNumbers.contains(0));
    }
}
