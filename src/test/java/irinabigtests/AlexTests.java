package irinabigtests;

import allclasses.irinabig.Alex;
import allclasses.irinabig.Feline;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AlexTests {
    @Test
    @DisplayName("Проверка того, что друзья Алекса - это Мартин, Глория, Мелман")
    @Description("Тестовый метод первый о том, что у Алекса есть друзья!")
    @Step("Шаг первый")
    public void testMethodOne() throws Exception {
        Feline  feline = new Feline();
        Alex alex = new Alex(feline);
        Assert.assertEquals(alex.getFriends(), List.of("Мартин", "Глория", "Мелман"));
    }
    @Test
    @DisplayName("Проверка того, что у Алекса нет котят")
    @Description("Тестовый метод второй о том, что у Алекса нет котят!")
    @Step("Шаг второй")
    public void testMethodTwo() throws Exception {
        Feline  feline = new Feline();
        Alex alex = new Alex(feline);
        Assert.assertEquals(alex.getKittens(), 0);
    }

}
