package Yumashkin;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import allclasses.yumashkin.Sport;
import org.junit.Assert;

import java.util.List;

public class YumashkinTests {
    @Test
    @DisplayName("test1")
    public void testGetSportReturnItems1() throws Exception {
        Sport sport = new Sport();
        Assert.assertEquals(sport.getSport("Хоккей"), List.of("Шайба", "Клюшка"));
    }
    @Test
    @DisplayName("test2")
    public void testGetSportReturnItems2() throws Exception {
        Sport sport = new Sport();
        Assert.assertEquals(sport.getSport("Футбол"), List.of("Футбольный мяч", "Бутсы"));
    }
    @Test
    public void testGetAnyPos() throws Exception {
        Sport sport = new Sport();
        Assert.assertEquals(sport.getPos(),("Есть такие виды позиций в спорте как: нападающий, защитник, вратарь"));
    }
}