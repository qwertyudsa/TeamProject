package MashkovaTest;

import allclasses.mashkova.Rabbits;
import org.junit.Assert;
import org.junit.Test;

public class RabbitsTest {

    @Test
    public void CheckTrueRabbitTest() {
        Rabbits rabbit = new Rabbits("Зайчонок");
        Assert.assertEquals("Ваш кролик есть в базе данных", rabbit.CheckRabbit());
    }

    @Test
    public void CheckFalseRabbitTest() {
        Rabbits rabbit = new Rabbits("Лопух");
        Assert.assertEquals("Вашего кролика нет в базе данных", rabbit.CheckRabbit());
    }
}
