package AndriyanovTest;

import allclasses.andriyanov.LongEaredJerboa;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;

import static org.junit.Assert.*;

public class LongEaredJerboaTest {

    @Test
    @DisplayName("Проверка начальных значений")
    @Description("Проверяет корректность инициализации полей при создании объекта LongEaredJerboa")
    @Step("Проверка начальных значений объекта")
    @TmsLink("TEST-1")
    public void testInitialValues() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        assertEquals("Начальный максимальный вес должен быть 100", 100, jerboa.maxWeight);
        assertEquals("Начальное количество попыток должно быть 0", 0, jerboa.attempts);
        assertEquals("Начальное количество успешных попыток должно быть 0", 0, jerboa.successfulAttempts);
    }

    @Test
    @DisplayName("Проверка успешного подъема")
    @Description("Проверяет, что при успешном подъеме вес попыток и успешных подъемов увеличивается")
    @Step("Выполнение успешной попытки подъема")
    @TmsLink("TEST-2")
    public void testSuccessfulLift() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        jerboa.attemptLift(90);
        assertEquals("Количество попыток должно быть 1", 1, jerboa.attempts);
        assertEquals("Количество успешных попыток должно быть 1", 1, jerboa.successfulAttempts);
    }

    @Test
    @DisplayName("Проверка подъема равного максимуму")
    @Description("Проверяет, что при подъеме веса, равного максимальному, все счетчики обновляются правильно")
    @Step("Выполнение подъема, равного максимальному весу")
    @TmsLink("TEST-3")
    public void testLiftEqualToMax() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        jerboa.attemptLift(100);
        assertEquals("Количество попыток должно быть 1", 1, jerboa.attempts);
        assertEquals("Количество успешных попыток должно быть 1", 1, jerboa.successfulAttempts);
    }


    @Test
    @DisplayName("Проверка неудачного подъема")
    @Description("Проверяет, что при неудачной попытке подъема, количество попыток увеличивается, а количество успешных попыток не меняется")
    @Step("Выполнение неудачной попытки подъема")
    @TmsLink("TEST-4")
    @Issue("BUG-1")
    public void testFailedLift() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        jerboa.attemptLift(110);
        assertEquals("Количество попыток должно быть 1", 1, jerboa.attempts);
        assertEquals("Количество успешных попыток должно быть 0", 0, jerboa.successfulAttempts);
    }

    @Test
    @DisplayName("Проверка увеличения максимального веса")
    @Description("Проверяет, что метод increaseMaxWeight корректно увеличивает максимальный вес")
    @Step("Увеличение максимального веса")
    @TmsLink("TEST-5")
    public void testIncreaseMaxWeight() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        int initialMaxWeight = jerboa.maxWeight;
        jerboa.increaseMaxWeight();
        assertTrue("Максимальный вес должен увеличиться. Текущий: " + jerboa.maxWeight + ", Изначальный: " + initialMaxWeight, jerboa.maxWeight > initialMaxWeight);
    }

    @Test
    @DisplayName("Проверка многократного увеличения максимального веса")
    @Description("Проверяет, что метод increaseMaxWeight корректно увеличивает максимальный вес при многократном вызове")
    @Step("Многократное увеличение максимального веса")
    @TmsLink("TEST-6")
    public void testIncreaseMaxWeightMultiple() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        int initialMaxWeight = jerboa.maxWeight;
        jerboa.increaseMaxWeight();
        jerboa.increaseMaxWeight();
        assertTrue("Максимальный вес должен увеличиться после двух вызовов. Текущий: " + jerboa.maxWeight + ", Изначальный: " + initialMaxWeight, jerboa.maxWeight > initialMaxWeight);
    }


    @Test
    @DisplayName("Проверка множественных попыток")
    @Description("Проверяет корректное обновление счетчиков попыток и успешных попыток при нескольких вызовах attemptLift")
    @Step("Выполнение нескольких попыток подъема")
    @TmsLink("TEST-7")
    public void testMultipleAttempts() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        jerboa.attemptLift(90);
        jerboa.attemptLift(110);
        jerboa.attemptLift(100);
        assertEquals("Количество попыток должно быть 3", 3, jerboa.attempts);
        assertEquals("Количество успешных попыток должно быть 2", 2, jerboa.successfulAttempts);
    }

    @Test
    @DisplayName("Проверка предела увеличения веса")
    @Description("Проверяет, что максимальный вес увеличивается при многократных вызовах increaseMaxWeight")
    @Step("Проверка увеличения веса до предела")
    @TmsLink("TEST-8")
    @Issue("BUG-2")
    public void testIncreaseWeightLimit() {
        LongEaredJerboa jerboa = new LongEaredJerboa("Ivan", 100);
        jerboa.increaseMaxWeight();
        jerboa.increaseMaxWeight();
        assertTrue("Максимальный вес должен увеличится", jerboa.maxWeight > 100);
    }
}