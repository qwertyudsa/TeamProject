package DemidovaTest;

import allclasses.demidova.Meow;
import org.junit.Assert;
import org.junit.Test;
//import io.qameta.allure.junit4.DisplayName; // импорт DisplayName

import static org.junit.Assert.assertEquals;

public class MeowTest {
    @Test
    public void testDefaultMeow() {
        Meow defaultMeow = new Meow();
        Assert.assertEquals("рысь", defaultMeow.getFelineType());
        Assert.assertEquals("Ирис", defaultMeow.getName());
    }

    @Test
    //@DisplayName("Проверка, что конструктор с парметрами работает верно")
    public void testConstructedMeow() {
        Meow constructedMeow = new Meow("пантера", "Барти");
        Assert.assertEquals("пантера", constructedMeow.getFelineType());
        Assert.assertEquals("Барти", constructedMeow.getName());
    }

    @Test
    public void testFelineMeow() {
        Meow cheetah = new Meow("гепард", "Герундий");
        Assert.assertEquals("гепард Герундий мяукает... Миу", cheetah.miaow());
    }
}
