package BalabanovaTest;
import allclasses.balabanova.Plant;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PlantTests {
    @Step("Проверка метода получения типов растений для категории {plantCategory}")
    @Test
    @DisplayName("Проверка получения типов растений для категории 'Цветковые'")
    @Description("Метод должен вернуть список типов растений для категории 'Цветковые'")
    @TmsLink("Test-Case 201")
    @Issue("BUG-101")
    public void testGetTypesReturnsFloweringPlants() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getTypes("Цветковые"), List.of("Роза", "Тюльпан", "Лилия"));
    }

    @Step("Проверка метода получения типов растений для категории {plantCategory}")
    @Test
    @DisplayName("Проверка получения типов растений для категории 'Всеядные'")
    @Description("Метод должен вернуть список типов растений для категории 'Всеядные'")
    @TmsLink("Test-Case 202")
    @Issue("BUG-102")
    public void testGetTypesReturnsNonFloweringPlants() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getTypes("Всеядные"), List.of("Папоротник", "Кактус", "Мох"));
    }

    @Step("Проверка обработки неизвестной категории {plantCategory}")
    @Test(expected = Exception.class)
    @DisplayName("Проверка обработки неизвестной категории растений")
    @Description("Метод должен выбросить исключение для неизвестной категории растений")
    @TmsLink("Test-Case 203")
    @Issue("BUG-103")
    public void testGetTypesThrowsExceptionForUnknownCategory() throws Exception {
        Plant plant = new Plant();
        plant.getTypes("Неизвестная категория");
    }

    @Step("Проверка метода получения среды обитания для растения {plantType}")
    @Test
    @DisplayName("Проверка получения среды обитания для растения 'Роза'")
    @Description("Метод должен вернуть среду обитания для растения 'Роза'")
    @TmsLink("Test-Case 204")
    @Issue("BUG-104")
    public void testGetHabitatForRose() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getHabitat("Роза"), "Сады и парки");
    }

    @Step("Проверка метода получения среды обитания для растения {plantType}")
    @Test
    @DisplayName("Проверка получения среды обитания для растения 'Кактус'")
    @Description("Метод должен вернуть среду обитания для растения 'Кактус'")
    @TmsLink("Test-Case 205")
    @Issue("BUG-105")
    public void testGetHabitatForCactus() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getHabitat("Кактус"), "Пустыни");
    }

    @Step("Проверка обработки неизвестного типа растения {plantType}")
    @Test(expected = Exception.class)
    @DisplayName("Проверка обработки неизвестного вида растения в методе получения среды обитания")
    @Description("Метод должен выбросить исключение для неизвестного вида растения")
    @TmsLink("Test-Case 206")
    @Issue("BUG-106")
    public void testGetHabitatThrowsExceptionForUnknownPlant() throws Exception {
        Plant plant = new Plant();
        plant.getHabitat("Неизвестный вид растения");
    }

    @Step("Проверка метода получения способа размножения для растения {plantType}")
    @Test
    @DisplayName("Проверка получения способа размножения для растения 'Роза'")
    @Description("Метод должен вернуть способ размножения для растения 'Роза'")
    @TmsLink("Test-Case 207")
    @Issue("BUG-107")
    public void testGetReproductionMethodForRose() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getReproductionMethod("Роза"), "Семенами или черенками.");
    }

    @Step("Проверка метода получения способа размножения для растения {plantType}")
    @Test
    @DisplayName("Проверка получения способа размножения для растения 'Кактус'")
    @Description("Метод должен вернуть способ размножения для растения 'Кактус'")
    @TmsLink("Test-Case 208")
    @Issue("BUG-108")
    public void testGetReproductionMethodForCactus() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getReproductionMethod("Кактус"), "Семенами, а также образованием дочерних растений.");
    }

    @Step("Проверка обработки неизвестного типа растения {plantType}")
    @Test(expected = Exception.class)
    @DisplayName("Проверка обработки неизвестного вида растения в методе получения способа размножения")
    @Description("Метод должен выбросить исключение для неизвестного вида растения")
    @TmsLink("Test-Case 209")
    @Issue("BUG-109")
    public void testGetReproductionMethodThrowsExceptionForUnknownPlant() throws Exception {
        Plant plant = new Plant();
        plant.getReproductionMethod("Неизвестный вид растения");
    }

    @Step("Проверка метода получения рекомендаций по уходу для растения {plantType}")
    @Test
    @DisplayName("Проверка получения рекомендаций по уходу для растения 'Роза'")
    @Description("Метод должен вернуть рекомендации по уходу для растения 'Роза'")
    @TmsLink("Test-Case 210")
    @Issue("BUG-110")
    public void testGetCareInstructionsForRose() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getCareInstructions("Роза"), "Полив раз в неделю, удобрение в сезон цветения.");
    }

    @Step("Проверка метода получения рекомендаций по уходу для растения {plantType}")
    @Test
    @DisplayName("Проверка получения рекомендаций по уходу для растения 'Кактус'")
    @Description("Метод должен вернуть рекомендации по уходу для растения 'Кактус'")
    @TmsLink("Test-Case 211")
    @Issue("BUG-111")
    public void testGetCareInstructionsForCactus() throws Exception {
        Plant plant = new Plant();
        Assert.assertEquals(plant.getCareInstructions("Кактус"), "Малый полив, предпочитает солнечные места.");
    }

    @Step("Проверка обработки неизвестного типа растения {plantType}")
    @Test(expected = Exception.class)
    @DisplayName("Проверка обработки неизвестного вида растения в методе получения рекомендаций по уходу")
    @Description("Метод должен выбросить исключение для неизвестного вида растения")
    @TmsLink("Test-Case 212")
    @Issue("BUG-112")
    public void testGetCareInstructionsThrowsExceptionForUnknownPlant() throws Exception {
        Plant plant = new Plant();
        plant.getCareInstructions("Неизвестный вид растения.");
    }
}
