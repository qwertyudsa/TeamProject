package FokinTests;

import allclasses.fokin.FokinClass;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test; // импорт DisplayName

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FokinTests {
    @DisplayName("Вывожу свой текст!")
    @Description("Тест проверяет вывод текста методом printMessage класса FokinClass.")
    @Test
    public void testPrintMessage() {
        FokinClass fc = new FokinClass();
        fc.printMessage("Hello, Fokin!");
    }
    @DisplayName("Тест сложения чисел!")
    @Description("Тест проверяет корректность сложения двух чисел методом calculateSum класса FokinClass.")
    @TmsLink("TestCase-1")
    @Issue("BUG-1")
    @Test
    public void testCalculateSum() {
        FokinClass fc = new FokinClass();
        assertEquals(5, fc.calculateSum(2, 3));
        methodForStepOne();
        assertEquals(0, fc.calculateSum(0, 0));
        methodForStepTwo();
        assertEquals(-1, fc.calculateSum(-1, 0));
        methodForStepThree();
    }
    @Step("Шаг первый")
    public void methodForStepOne(){
        System.out.println("Вызов метода шага 1");
    }
    @Step("Шаг Второй")
    public void methodForStepTwo(){
        System.out.println("Вызов метода шага 2");
    }
    @Step("Шаг третий")
    public void methodForStepThree(){
        System.out.println("Вызов метода шага 3");
    }

    @DisplayName("Проверка генерации рандомного массива!")
    @Description("Тест проверяет корректность генерации случайного массива методом generateRandomArray класса FokinClass.")
    @Test
    public void testGenerateRandomArray() {
        FokinClass fc = new FokinClass();
        int[] randomArray = fc.generateRandomArray(5, 10);

        assertEquals(5, randomArray.length); // Проверяем, что размер массива равен 5
        for (int num : randomArray) {
            assertTrue(num >= 0 && num < 10); // Проверяем, что все числа в диапазоне [0, 10)
        }
    }
}
