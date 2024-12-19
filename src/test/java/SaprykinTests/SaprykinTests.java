package SaprykinTests;

import allclasses.saprykin.SaprykinClass;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;

public class SaprykinTests {

    @Test
    @DisplayName("Проверка информации о студенте")
    @Description("Тест проверяет корректность метода getStudentInfo для возвращения полной информации о студенте.")
    @TmsLink("TestCase-112")
    @Issue("BUG-282")
    public void testGetStudentInfo() {
        SaprykinClass student = createStudent("Семён Сапрыкин", 20, 4.7);
        String expectedInfo = "Имя студента: Семён Сапрыкин, Возраст: 20, Средний балл: 4.7";
        verifyStudentInfo(student, expectedInfo);
    }

    @Test
    @DisplayName("Проверка, что студент является отличником")
    @Description("Тест проверяет, что метод isExcellentStudent возвращает true для студента с высоким средним баллом.")
    public void testIsExcellentStudent_True() {
        SaprykinClass student = createStudent("Семён Сапрыкин", 20, 4.7);
        verifyIsExcellentStudent(student, true);
    }

    @Test
    @DisplayName("Проверка, что студент не является отличником")
    @Description("Тест проверяет, что метод isExcellentStudent возвращает false для студента с низким средним баллом.")
    public void testIsExcellentStudent_False() {
        SaprykinClass student = createStudent("Семён Сапрыкин", 20, 4.2);
        verifyIsExcellentStudent(student, false);
    }

    @Test
    @DisplayName("Проверка изменения среднего балла студента")
    @Description("Тест проверяет, что метод setAverageGrade корректно обновляет средний балл студента.")
    public void testSetAverageGrade() {
        SaprykinClass student = createStudent("Семён Сапрыкин", 20, 4.7);
        updateAverageGrade(student, 3.5);
        verifyAverageGrade(student, 3.5);
    }

    @Test
    @DisplayName("Проверка студента с максимальным средним баллом")
    @Description("Тест проверяет, что студент с максимальным средним баллом (5.0) является отличником.")
    public void testMaxAverageGradeStudent() {
        SaprykinClass student = createStudent("Анна Иванова", 21, 5.0);
        verifyIsExcellentStudent(student, true);
    }

    @Test
    @DisplayName("Проверка студента с минимальным средним баллом")
    @Description("Тест проверяет, что студент с минимальным средним баллом (2.0) не является отличником.")
    public void testMinAverageGradeStudent() {
        SaprykinClass student = createStudent("Иван Петров", 19, 2.0);
        verifyIsExcellentStudent(student, false);
    }

    @Step("Создание студента: имя={name}, возраст={age}, средний балл={averageGrade}")
    private SaprykinClass createStudent(String name, int age, double averageGrade) {
        return new SaprykinClass(name, age, averageGrade);
    }

    @Step("Проверка информации о студенте")
    private void verifyStudentInfo(SaprykinClass student, String expectedInfo) {
        Assert.assertEquals(expectedInfo, student.getStudentInfo());
    }

    @Step("Проверка, является ли студент отличником")
    private void verifyIsExcellentStudent(SaprykinClass student, boolean expected) {
        Assert.assertEquals(expected, student.isExcellentStudent());
    }

    @Step("Обновление среднего балла студента на {newAverageGrade}")
    private void updateAverageGrade(SaprykinClass student, double newAverageGrade) {
        student.setAverageGrade(newAverageGrade);
    }

    @Step("Проверка среднего балла студента: ожидается {expectedGrade}")
    private void verifyAverageGrade(SaprykinClass student, double expectedGrade) {
        Assert.assertEquals(expectedGrade, student.getAverageGrade(), 0.01);
    }
}
