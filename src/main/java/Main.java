import allclasses.fokin.FokinClass;
import allclasses.irinabig.Animal;
import allclasses.irinabig.Cat;
import allclasses.irinabig.Feline;
import allclasses.irinabig.Lion;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Демонстрация работы классов пакета irinabig
        try {
            showClassesIrinaBig();
            showClassesFokin();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public  static void showClassesIrinaBig() throws Exception {
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
    public static void showClassesFokin() {
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
}