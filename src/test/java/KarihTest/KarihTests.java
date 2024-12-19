package KarihTest;
import allclasses.Karih.Cat;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class KarihTests {
    @Test
    @DisplayName("Проверка, что кошка мяукнет 3 раза")
    @Description("Кошка пытаеться мяукнуть 3 раза")
    @TmsLink("TestCase-0125")
    @Issue("BUG-557")
    public void Meow3Times()
    {
        Cat cat1 = CreateCat("Charlotte", 10);
        StepTwo();
        Assert.assertEquals("Meow Meow Meow", cat1.Meow(3));
    }
    @Test
    @DisplayName("Проверка, что кошка не мяукнет")
    @Description("Кошка не мяукает")
    @TmsLink("TestCase-0315")
    @Issue("BUG-512")
    public void Meow0Times(){

        Cat cat1 = CreateCat("Charlotte", 10);
        StepTwo();
        Assert.assertEquals("", cat1.Meow(0));
    }
    @Test
    @DisplayName("Проверка, что возраст кошки соответствует указанному")
    @Description("Возраст кошки равен указанному")
    @TmsLink("TestCase-0412")
    @Issue("BUG-451")
    public void GetCatAge(){

        Cat cat1 = CreateCat("Charlotte", 10);
        StepTwo();
        Assert.assertEquals(10, cat1.age);
    }
    @Test
    @DisplayName("Проверка,  что имя кошки соответствует указанному")
    @Description("Имя кошки равно указанному")
    @TmsLink("TestCase-0512")
    public void GetCatName(){

        Cat cat1 = CreateCat("Charlotte", 10);
        StepTwo();
        Assert.assertEquals("Charlotte", cat1.name);
    }



    @Step("Шаг первый - создаем кота с указанным возрастом и именем")
    public Cat CreateCat(String name, int age)
    {
        return new Cat(age, name);
    }
    @Step("Шаг второй - сравниваем значения")
    public void StepTwo()
    {
        System.out.println("Assert values");
    }

}
