package PokrovskayaTest;

import allclasses.Pokrovskaya.PokrovClass;
import org.junit.Assert;
import org.junit.Test;

public class PokrovskayaTest {

    // Тест для метода start()
    @Test
    public void getStart() {
        // Создаем объект транспорта
        PokrovClass pokrovClass = new PokrovClass("Автомобиль", 4);

        Assert.assertEquals("Транспорт типа Автомобиль запускается.", pokrovClass.start());
    }

    // Тест для метода stop()
    @Test
    public void testStop() {
        // Создаем объект транспорта
        PokrovClass pokrovClass = new PokrovClass("Велосипед", 1);

        Assert.assertEquals("Транспорт типа Велосипед остановлен.", pokrovClass.start());
    }

    // Тест для проверки значений полей type и capacity
    @Test
    public void testTransportFields() {
        // Создаем объект транспорта
        PokrovClass pokrovClass = new PokrovClass("Автомобиль", 5);

        // Проверяем корректность значений
        Assert.assertEquals("Автомобиль", pokrovClass.getType());
        Assert.assertEquals(5, pokrovClass.getCapacity());
    }
}
