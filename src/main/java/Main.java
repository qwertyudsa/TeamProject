import allclasses.irinabig.Animal;
import allclasses.irinabig.Cat;
import allclasses.irinabig.Feline;
import allclasses.irinabig.Lion;
import allclasses.petrov.Programmer;
import allclasses.stebunov.Wolf;

import allclasses.strelnikov.Capybara;

import allclasses.fokin.FokinClass;

import allclasses.yakimovich.YakimovichClass;
import allclasses.yakovleva.*;
import allclasses.chernyshova.Mouse;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Демонстрация работы классов пакета irinabig
        try {
            showClassesIrinaBig();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        showClassesPetrov();
        showClassesStebunov();
        showClassesFokin();
        showClassesYakimovich();
        showClassesYakovleva();
        showClassesVolodin();
        showClassesBezrukih();
        showClassesChernyshova();
        showClassesStrelnikov();
    }

    public static void showClassesIrinaBig() throws Exception {
        System.out.println("\nДемонстрация работы классов Ирины Георгиевны:");
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
        System.out.println("\nДемонстрация работы классов Петрова Артёма:");
        Programmer programmer = new Programmer("Артем", 18);
        programmer.writeCode();
        programmer.drinkCoffee();
        programmer.debugCode();
    }

    public static void showClassesYakimovich() {
        System.out.println("\nДемонстрация работы класса Якимовича Андрея:");
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
        System.out.println("\nДемонстрация работы класса Фокина Дениса:");
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

    public static void showClassesStebunov() {
        System.out.println("\nДемонстрация работы класса Стебунова Никиты:");

        // Создание волка с помощью конструктора по умолчанию
        Wolf defaultWolf = new Wolf();
        System.out.println("Волк, созданный с использованием конструктора по умолчанию:");
        defaultWolf.printInfo();

        System.out.println("Изменение имени, возраста и веса волка. Измененный волк:");
        // Изменение параметров волка
        defaultWolf.setName("Белый");
        defaultWolf.setAge(5);
        defaultWolf.setWeight(35.5);
        // Вывод информации о волке
        defaultWolf.printInfo();

        // Создание волка с параметрами
        Wolf customWolf = new Wolf("Серый", 7, 42.3);
        System.out.println("\nВолк, созданный с использованием конструктора с параметрами:");
        customWolf.printInfo();

        // Демонстрация метода howl
        System.out.println("\nДемонстрация метода - Волк воет:");
        defaultWolf.howl();
        customWolf.howl();
    }

    public static void showClassesYakovleva() {
        System.out.println("\nДемонстрация работы класса Яковлевой Анны:");
        
        // Создание оленя с помощью конструктора по умолчанию
        Deer deer = new Deer("Lin", LocalDate.of(2020, 11, 3), Type.благородный);
        deer.Info();

        // Изменение параметров оленя
        deer.setName("Linnie");
        System.out.println("Изменение имени..");
        deer.Info();

        // Демонстрация метода Age
        System.out.println("Возраст оленя на данный момент: " + deer.Age());
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

    public static void showClassesStrelnikov(){
        // Создаём объект капибары
        Capybara capy = new Capybara("Каппи", 3, 35.5);
        // Тестируем методы
        capy.displayInfo();        // Печатаем информацию
        capy.speak();              // Капибара говорит
        capy.eat(2.0);             // Капибара ест
        capy.swim();               // Капибара плавает
        capy.play(1.5);            // Капибара играет
        capy.growOlder();          // Капибара стареет
        capy.displayInfo();        // Ещё раз печатаем информацию
    }
}