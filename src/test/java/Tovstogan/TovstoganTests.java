package Tovstogan;

import allclasses.tovstogan.Student;
import allclasses.tovstogan.Tovstogan;
import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
//import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import java.util.List;

public class TovstoganTests {
    @Test

//    @DisplayName("Первый тест")
    public void testMethodOne() throws Exception {
        Tovstogan T = new Tovstogan();
        Assert.assertEquals("Hello", T.returnHello());
    }
    @Test
//    @org.junit.jupiter.api.DisplayName("Второй тест")
    public void testMethodTwo() throws Exception {
        int group = 123;
        Student S = new Student("Имя", "Фамилия", group);
        Assert.assertEquals(group, S.getGroup());
    }
}
