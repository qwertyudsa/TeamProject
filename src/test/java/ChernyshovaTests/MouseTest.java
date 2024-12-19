package ChernyshovaTests;

import allclasses.chernyshova.Mouse;
import org.junit.Test;
import java.time.LocalDate;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import io.qameta.allure.Description; // - импорт Description
import io.qameta.allure.Step; // - импорт Step
import static org.junit.Assert.*;

public class MouseTest {

    @Test
    @DisplayName("Тест с самой обычной серой домовой мышкой")
    @Description("Проверяем, что созданная по умолчанию мышка имеет правильный цвет, вид, вес и дату рождения.")
    public void testDefaultMouse() {
        methodForStepOne();
        Mouse defaultMouse = new Mouse();
        assertEquals("серая", defaultMouse.getColor());
        assertEquals("домовая", defaultMouse.getSpecies());
        assertEquals(25.0, defaultMouse.getWeight(), 0.01);
        assertEquals(LocalDate.now(), defaultMouse.getBirthDate());
    }

    @Step("Шаг первый")
    public void methodForStepOne(){
        System.out.println("Вызов метода шага 1");
    }

    @Test
    @DisplayName("Тест с годовалой мышкой")
    @Description("Создаем мышку с заданными параметрами и проверяем их соответствие.")
    public void testCustomMouse() {
        methodForStepTwo();
        LocalDate birthDate = LocalDate.of(2023, 11, 1);
        Mouse customMouse = new Mouse("белая", "полевка", 30.5, birthDate);
        assertEquals("белая", customMouse.getColor());
        assertEquals("полевка", customMouse.getSpecies());
        assertEquals(30.5, customMouse.getWeight(), 0.01);
        assertEquals(birthDate, customMouse.getBirthDate());
    }

    @Test
    @DisplayName("Тест установки веса мышки с отрицательным значением")
    @Description("Проверяем, что установка отрицательного веса не изменяет вес мышки по умолчанию.")
    public void testSetWeight() {
        methodForStepThree();
        Mouse mouse = new Mouse();
        mouse.setWeight(-10.0); // установка отрицательного веса
        assertEquals(25.0, mouse.getWeight(), 0.01);
    }

    @Test
    @DisplayName("Тест расчета возраста мышки")
    @Description("Проверяем, что возраст мышки рассчитывается правильно на основе даты рождения.")
    public void testAgeCalculate() {
        methodForStepFour();
        LocalDate birthDate = LocalDate.of(2024, 1, 1);
        Mouse mouse = new Mouse("серая", "домовая", 20.0, birthDate);
        long expectedAge = LocalDate.now().toEpochDay() - birthDate.toEpochDay();
        assertEquals(expectedAge, mouse.getAgeInDays());
    }

    @Test
    @DisplayName("Тест установки недопустимой даты рождения мышки")
    @Description("Проверяем, что установка даты рождения в будущем не допускается.")
    public void testSetFalseBirthDate() {
        methodForStepFive();
        Mouse mouse = new Mouse();
        LocalDate futureDate = LocalDate.now().plusDays(1);
        mouse.setBirthDate(futureDate); // установка будущего значения
        assertNotEquals(futureDate, mouse.getBirthDate());
    }

    @Step("Шаг второй")
    public void methodForStepTwo(){
        System.out.println("Вызов метода шага 2");
    }
    @Step("Шаг третий")
    public void methodForStepThree(){
        System.out.println("Вызов метода шага 3");
    }
    @Step("Шаг четвертый")
    public void methodForStepFour(){
        System.out.println("Вызов метода шага 4");
    }
    @Step("Шаг пятый")
    public void methodForStepFive(){
        System.out.println("Вызов метода шага 5");
    }
}