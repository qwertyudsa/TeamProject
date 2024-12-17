package DemidovaTest;

import allclasses.demidova.Meow;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;

import static org.junit.Assert.assertEquals;

public class MeowTest {
    @Test
    @DisplayName("Проверка, что вид и имя кошачьего по умолчанию создается корректно")
    @Description("Конструктор по умолчанию корректно устанавливает вид кошачьего и имя кошачьего")
    public void testDefaultMeow() {
        Meow defaultMeow = new Meow();
        Assert.assertEquals("рысь", defaultMeow.getFelineType());
        Assert.assertEquals("Ирис", defaultMeow.getName());
    }

    @Test
    @DisplayName("Проверка, что вид и имя кошачьего устанавливаются корректно")
    @Description("Конструктор корректно устанавливает переданные в него значения: вид кошачьего и имя кошачьего")
    public void testConstructedMeow() {
        Meow constructedMeow = new Meow("пантера", "Барти");
        Assert.assertEquals("пантера", constructedMeow.getFelineType());
        Assert.assertEquals("Барти", constructedMeow.getName());
    }

    @Test
    @DisplayName("Проверка, что кошачий может мяукать")
    @Description("Метод miaow отображается корректно")
    public void testFelineMeow() {
        Meow cheetah = new Meow("гепард", "Герундий");
        Assert.assertEquals("гепард Герундий мяукает... Миу", cheetah.miaow());
    }

    @Test
    @DisplayName("Проверка, что кошачий идёт")
    @Description("Метод stepMeow работает корректно и выводит шаги")
    @TmsLink("TestCase-4")  // ссылка на тест кейс
    @Issue("BUG-983")  // ссылка на баг-репорт
    public void testStepMeow() {
        Meow panther = new Meow("пантера", "Барти");
        verifyStepMeow(panther, 3, "пантера Барти идёт...\nШаг 1\nШаг 2\nШаг 3\n");
    }

    @Step("Проверяем метод stepMeow с {steps} шагами")
    public void verifyStepMeow(Meow feline, int steps, String expectedOutput) {
        String actualOutput = stepMeowOutput(feline, steps);
        Assert.assertEquals("Вывод метода stepMeow не совпадает с ожидаемым", expectedOutput, actualOutput);
    }

    @Step("Запускаем метод stepMeow")
    public String stepMeowOutput(Meow feline, int steps) {
        return feline.stepMeow(steps);
    }
}
