import allclasses.fokin.FokinClass;
import allclasses.irinabig.Animal;
import allclasses.irinabig.Cat;
import allclasses.irinabig.Feline;
import allclasses.irinabig.Lion;
import allclasses.petrov.Programmer;
import allclasses.yakimovich.YakimovichClass;
import allclasses.chernyshova.Mouse;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Демонстрация работы классов пакета irinabig
        try {
            showClassesIrinaBig();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        showClassesPetrov();
        showClassesYakimovich();
        showClassesFokin();
        showClassesVolodin();
        showClassesBezrukih();
        showClassesChernyshova();
    }
    public static void showClassesIrinaBig() throws Exception {
        System.out.println("\nДемонстрация работы классов Ирины Георгиевны:\n");
        Feline feline = new Feline();
        System.out.println("Создан объект семейства " + feline.getFamily());
        Animal animal = new Animal();
        System.out.println(animal.getFamily());

        Cat cat = new Cat(feline);
        System.out.println("Объект кошка умеет говорить: " + cat.getSound());
        Lion lion = new Lion("Самец", feline);
        System.out.println("Кошка питается => " + cat.getFood().toString());
        System.out.println("Лев питается => " + lion.getFood().toString());
        System.out.println("Кошачьи питаются => " + feline.getFood("Хищник") .toString());
    }

    public  static void showClassesPetrov() {
        System.out.println("\nДемонстрация работы классов Петрова Артёма:\n");
        Programmer programmer = new Programmer("Артем", 18);
        programmer.writeCode();
        programmer.drinkCoffee();
        programmer.debugCode();
    }

    public static void showClassesYakimovich() {
        System.out.println("\nДемонстрация работы класса Якимовича Андрея:\n");
        YakimovichClass test = new YakimovichClass();
        System.out.println("Результаты вычислений YakimovichClass:");
        System.out.println("Сумма 5 + 3 = " + test.add(5, 3));
        System.out.println("Разность 10 - 4 = " + test.subtract(10, 4));
        System.out.println("Произведение 6 * 2 = " + test.multiply(6, 2));
        try {
            System.out.println("Деление 10 / 2 = " + test.divide(10, 2));
            System.out.println("Деление 15 / 0 = " + test.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Четные числа от 0 до 10: " + test.generateEvenNumbers(10));
    }
    public static void showClassesFokin() {
        System.out.println("\nДемонстрация работы класса Фокина Дениса:\n");
        FokinClass fokinClass = new FokinClass();

        // Выводим сообщение
        fokinClass.printMessage("Привет из группы С224 от Метафоры(Дениса)!");

        // Рассчитываем сумму двух чисел
        int sum = fokinClass.calculateSum(5, 10);
        System.out.println("Сумма 5 и 10 равна: " + sum + ", Ого!");

        // Генерируем массив случайных целых чисел
        int[] randomArray = fokinClass.generateRandomArray(5, 100); // Массив из 5 случайных чисел до 100
        System.out.print("Случайный массив: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println(); // Переход на новую строку
    }
    public static void showClassesVolodin() {
        System.out.println("\nДемонстрация работы класса Володина Андрея:\n");

    }
    public static void showClassesBezrukih() {
        System.out.println("\nДемонстрация работы класса Безруких Алексея:\n");
    }

    public static void showClassesChernyshova() {
        System.out.println("\nДемонстрация работы классов Чернышовой Софьи:\n");

        // Создаем объект пользовательской мыши
        Mouse customMouse = new Mouse("белая", "полевка", 30.5, LocalDate.of(2023, 11, 1));
        System.out.println("Создан объект пользовательской мыши:");
        customMouse.describeMouse();

        // Проверяем возраст в днях
        System.out.println("\nВозраст пользовательской мыши в днях: " + customMouse.getAgeInDays());

        // Проверка с неверной датой рождения
        System.out.println("\nПопытка установить будущую дату рождения:");
        customMouse.setBirthDate(LocalDate.now().plusDays(1));
        System.out.println("Дата рождения после проверки: " + customMouse.getBirthDate());
    }


}