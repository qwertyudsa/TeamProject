package irinabigtests;

import allclasses.irinabig.Alex;
import allclasses.irinabig.Feline;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
public class AlexTests {
    @Test
    @DisplayName("Проверка того, что друзья Алекса - это Мартин, Глория, Мелман")
    @Description("Тестовый метод первый о том, что у Алекса есть друзья!")
    @TmsLink("TestCase-112") // ссылка на тест-кейс
    @Issue("BUG-985") // ссылка на баг-репорт
    public void testMethodOne() throws Exception {
        Feline  feline = new Feline();
        Alex alex = new Alex(feline);
        methodForStepOne();
        methodForStepTwo();
        methodForStepThree();
        Assert.assertEquals(alex.getFriends(), List.of("Мартин", "Глория", "Мелман"));
    }
    @Step("Шаг первый")
    public void methodForStepOne(){
        System.out.println("Вызов метода шага 1");
    }
    @Step("Шаг второй")
    public void methodForStepTwo(){
        System.out.println("Вызов метода шага 2");
    }
    @Step("Шаг третий")
    public void methodForStepThree(){
        System.out.println("Вызов метода шага 3");
    }

    @Test
    @DisplayName("Проверка того, что у Алекса нет котят")
    @Description("Тестовый метод второй о том, что у Алекса нет котят!")
    public void testMethodTwo() throws Exception {
        Feline  feline = new Feline();
        Alex alex = new Alex(feline);
        Assert.assertEquals(alex.getKittens(), 0);
    }
}
