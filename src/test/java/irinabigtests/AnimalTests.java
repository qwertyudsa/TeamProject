package irinabigtests;

import allclasses.irinabig.Animal;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTests {
    @Test
    @DisplayName("Проверка того, что хищники едят Животных, Птиц и Рыб")
    @Description("Список еды для хищника")
    public void testGetFoodReturnsFoodForPredators() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(animal.getFood("Хищник"), List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    @DisplayName("Проверка того, что травоядные едят траву, различные растения")
    @Description("Список еды для травоядного")
    public void testGetFoodReturnsFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(animal.getFood("Травоядное"), List.of("Трава", "Различные растения"));
    }
}
