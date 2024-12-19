package irinabigtests;

import allclasses.irinabig.Animal;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTests {
    @Test
    @DisplayName("test5")
    public void testGetFoodReturnsFoodForPredators() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(animal.getFood("Хищник"), List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    @DisplayName("test6")
    public void testGetFoodReturnsFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(animal.getFood("Травоядное"), List.of("Трава", "Различные растения"));
    }
}
