package irinabigtests;

import allclasses.irinabig.Feline;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class FelineTests {

    @Test
    @DisplayName("Проверка, что КОШКИ по умолчанию имеют одного котенка")
    @Description("Кошачьи имеют одного котенка")
    public void GetKittensTest(){
        Feline feline = new Feline();
        int expected = 1;
        Assert.assertEquals(expected, feline.getKittens());
    }
}
