package BuravlevTest;

import allclasses.buravlev.Pet;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class BuravlevTest {
    @Test
    @DisplayName("Проверка конструктора класса")
    @Description("Кот Крошик, 18кг, 11 лет")
    @TmsLink("TestCase-1")
    @Issue("BUG-1337")
    public void testGetInfo() throws Exception{
        Pet cat = new Pet("Крошик", 18 , "кот", 11 );

        Assert.assertEquals("Type: кот, Weight: 18 kg, Age: 11 years", cat.getInfo());
    }
    @Test
    @DisplayName("Проверка является ли Барбос взрослым")
    @Description("Собака Барбос, взрослый (8 лет)")
    @TmsLink("TestCase-2")
    @Issue("BUG-1338")
    public void testIsAdult() throws  Exception{
        Pet dog = createPet("Барбос", 20, "собака", 8);
        boolean expected = true;
        boolean actual = checkIfPetIsAdult(dog);
        compareResult(expected, actual);
    }
    @Step("Создание питомца с именем {name}, весом {weight}, видом {type}, возрастом {age}")
    private Pet createPet(String name, int weight, String type, int age){
        return new Pet(name, weight, type, age);
    }
    @Step("Проверяем является ли питомец взрослым")
    private boolean checkIfPetIsAdult(Pet pet){
        return pet.isAdult();
    }
    @Step("Сравниваем ожидаемый результат {expected} с фактическим {actual}")
    private void compareResult(boolean expected, boolean actual){
        Assert.assertEquals(expected, actual);
    }
}
