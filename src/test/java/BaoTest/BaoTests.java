package BaoTest;


import allclasses.Bao.Person;
import org.junit.Assert;
import io.qameta.allure.Allure;
import org.junit.Test;

import io.qameta.allure.junit4.DisplayName;



import static org.junit.Assert.assertEquals;


public class BaoTests {
    @Test
    @DisplayName("Проверка, что возраст корректный")
    public void GetAge20Get20()
    {
        Person instance = new Person("Владимир", "Гайкин", 20);
        int expectedAge = 20;

        Assert.assertEquals(expectedAge, instance.GetAge());

    }

    @Test
    public void GetInitialsNameSurname()
    {
        Person instance = new Person("Владимир", "Гайкин", 20);

        String expectedInitials = "Владимир Гайкин";

        Assert.assertEquals(expectedInitials,instance.GetInitials());
    }

    @Test
    public void GetFieldDefaultPerson()
    {
        Person instance = new Person();

        String expectedName = "Иван";

        Assert.assertEquals(expectedName, instance.name);
    }
}
