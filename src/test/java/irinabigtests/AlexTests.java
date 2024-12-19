package irinabigtests;

import allclasses.irinabig.Alex;
import allclasses.irinabig.Feline;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AlexTests {
    @Test
    @DisplayName("test3")
    public void testMethodOne() throws Exception {
        Feline  feline = new Feline();
        Alex alex = new Alex(feline);
        Assert.assertEquals(alex.getFriends(), List.of("Мартин", "Глория", "Мелман"));
    }
    @DisplayName("test4")
    @Test
    public void testMethodTwo() throws Exception {
        Feline  feline = new Feline();
        Alex alex = new Alex(feline);
        Assert.assertEquals(alex.getKittens(), 0);
    }

}
