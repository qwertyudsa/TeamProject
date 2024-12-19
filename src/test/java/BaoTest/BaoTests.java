package BaoTest;


import allclasses.Bao.Person;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import io.qameta.allure.Allure;
import org.junit.Test;

import io.qameta.allure.junit4.DisplayName;



import static org.junit.Assert.assertEquals;


public class BaoTests {
    @Test
    @DisplayName("Проверка, что возраст корректный")
    @Description("Создается объект класса и возраст берется с помощью метода GetAge()")
    public void GetAge20Get20()
    {
        Person instance = new Person("Владимир", "Гайкин", 20);
        int expectedAge = 20;

        Assert.assertEquals(expectedAge, instance.GetAge());

    }

    @Test
    @DisplayName("Проверка корректности инициалов")
    public void GetInitialsNameSurname()
    {
        Person instance = InitializePerson();

        ChangeName(instance, "Иван");

        String expectedInitials = "Иван Гайкин";

        Assert.assertEquals(expectedInitials,instance.GetInitials());
    }

    @Test
    @DisplayName("Првоерка правильности имени")
    public void GetFieldDefaultPerson()
    {

        Person instance = InitializePerson();

        String expectedName = "Владимир";

        Assert.assertEquals(expectedName, instance.name);
    }

    @Step("Инициализация объекта")
    public Person InitializePerson()
    {
        Person instance = new Person("Владимир", "Гайкин",20);

        return instance;
    }

    @Step("Изменение имени")
    public void ChangeName(Person instance, String newName)
    {
        instance.name = newName;
    }
}
