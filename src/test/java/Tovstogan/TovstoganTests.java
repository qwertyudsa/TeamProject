package Tovstogan;

import allclasses.tovstogan.Student;
import allclasses.tovstogan.Tovstogan;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import java.util.List;

public class TovstoganTests {
    @Test

    @DisplayName("Первый тест")
    @Description("Описание первого теста")
    @TmsLink("TestCase-112")
    @Issue("BUG-985")
    public void testMethodOne() throws Exception {
        Tovstogan T = new Tovstogan();
        Assert.assertEquals("Hello", T.returnHello());
    }
    @Test
    @DisplayName("Второй тест")
    @Description("Описание Второго теста")
    public void testMethodTwo() throws Exception {
        int group = 123;
        Student S = new Student("Имя", "Фамилия", group);
        Assert.assertEquals(group, S.getGroup());
    }

    @Step("шаг 1")
    public void methodOne(){
        System.out.println("Вызов метода шаг 1");
    }

    @Step("шаг 2")
    public void methodTwo(){
        System.out.println("Вызов метода шаг 2");
    }
    @Step("шаг 3")
    public void methodThree(){
        System.out.println("Вызов метода шаг 3");
    }
}
