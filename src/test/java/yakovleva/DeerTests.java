package yakovleva;

import allclasses.yakovleva.Deer;
import allclasses.yakovleva.Type;

import java.time.LocalDate;
import java.time.Period;

import org.junit.Assert;
import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName

public class DeerTests 
{
    @Test
    @DisplayName("Проверка метода подсчета возраста оленя день рождения которого до сегодняшнего дня")
    @Description("Проверка метода подсчета возраста оленя день рождения которого до сегодняшнего дня (12.01.2020)")
    @TmsLink("Test-Case 101")
    @Issue("BUG-404")
    public void AgeDayBeforeToday3() 
    {
        Deer deer = new Deer("Ми", LocalDate.of(2020, 1, 12), Type.лань);
       
        int actual = deer.Age();

        Period period = Period.between(deer.getBirthday(), LocalDate.now());
        int expected = period.getYears();

        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка метода подсчета возраста оленя день рождения которого позже сегодняшнего дня")
    @Description("Проверка метода подсчета возраста оленя день рождения которого позже сегодняшнего дня (28.12.2020)")
    @TmsLink("Test-Case 102")
    @Issue("BUG-404")
    public void AgeDayAfterToday2() 
    {
        Deer deer = new Deer("Ми", LocalDate.of(2020, 12, 28), Type.лань);
       
        int actual = deer.Age();
        
        Period period = Period.between(deer.getBirthday(), LocalDate.now());
        int expected = period.getYears();

        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка метода подсчета возраста оленя день рождения которого еще не наступил")
    @Description("Проверка метода подсчета возраста оленя день рождения которого еще не наступил в этом году (12.12.2026)")
    @TmsLink("Test-Case 103")
    @Issue("BUG-404")
    public void AgeDateAfterToday0() 
    {
        Deer deer = new Deer("Ми", LocalDate.of(2026, 12, 12), Type.лань);
       
        int actual = deer.Age();

        int expected = 0;

        Assert.assertEquals(expected, actual);
    }
}