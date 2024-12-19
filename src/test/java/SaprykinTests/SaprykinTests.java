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

    @Test
    @DisplayName("Проверка отрицательного среднего балла")
    @Description("Тест проверяет, что установка отрицательного среднего балла вызывает исключение.")
    public void testNegativeAverageGrade() {
        SaprykinClass student = createStudent("Мария Смирнова", 22, 3.0);
        Assert.assertThrows(IllegalArgumentException.class, () -> updateAverageGrade(student, -1.0));
    }

    @Test
    @DisplayName("Проверка обновления имени студента")
    @Description("Тест проверяет, что метод setName корректно обновляет имя студента.")
    public void testUpdateStudentName() {
        SaprykinClass student = createStudent("Олег Иванов", 20, 3.8);
        updateStudentName(student, "Олег Петров");
        verifyStudentName(student, "Олег Петров");
    }

    @Test
    @DisplayName("Проверка изменения возраста студента")
    @Description("Тест проверяет, что метод setAge корректно обновляет возраст студента.")
    public void testUpdateStudentAge() {
        SaprykinClass student = createStudent("Елена Орлова", 19, 4.5);
        updateStudentAge(student, 21);
        verifyStudentAge(student, 21);
    }

    @Test
    @DisplayName("Проверка максимального возраста студента")
    @Description("Тест проверяет, что установка возраста больше 100 вызывает исключение.")
    public void testMaxStudentAge() {
        SaprykinClass student = createStudent("Александр Сидоров", 20, 3.0);
        Assert.assertThrows(IllegalArgumentException.class, () -> updateStudentAge(student, 101));
    }

    @Test
    @DisplayName("Проверка минимального возраста студента")
    @Description("Тест проверяет, что установка возраста меньше 16 вызывает исключение.")
    public void testMinStudentAge() {
        SaprykinClass student = createStudent("Василий Кузнецов", 18, 4.0);
        Assert.assertThrows(IllegalArgumentException.class, () -> updateStudentAge(student, 15));
    }

    @Test
    @DisplayName("Проверка корректности метода equals")
    @Description("Тест проверяет, что метод equals корректно сравнивает два одинаковых объекта.")
    public void testEqualsMethod() {
        SaprykinClass student1 = createStudent("Юлия Романова", 20, 4.3);
        SaprykinClass student2 = createStudent("Юлия Романова", 20, 4.3);
        Assert.assertEquals(student1, student2);
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

    @Step("Обновление имени студента на {newName}")
    private void updateStudentName(SaprykinClass student, String newName) {
        student.setName(newName);
    }

    @Step("Проверка имени студента: ожидается {expectedName}")
    private void verifyStudentName(SaprykinClass student, String expectedName) {
        Assert.assertEquals(expectedName, student.getName());
    }

    @Step("Обновление возраста студента на {newAge}")
    private void updateStudentAge(SaprykinClass student, int newAge) {
        student.setAge(newAge);
    }

    @Step("Проверка возраста студента: ожидается {expectedAge}")
    private void verifyStudentAge(SaprykinClass student, int expectedAge) {
        Assert.assertEquals(expectedAge, student.getAge());
    }
}
