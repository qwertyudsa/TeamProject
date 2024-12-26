package allclasses.Pokrovskaya;
//класс транспорт
public class PokrovClass {
    // Свойства (поля) класса
    private String type; // Тип транспорта (например, автомобиль, велосипед, поезд)
    private int capacity; // Вместимость (количество пассажиров)

    // Конструктор класса для инициализации значений
    public PokrovClass(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    // Метод для запуска транспорта
    public String start() {
        return "Транспорт типа " + type + " запускается.";
    }


    // Метод для остановки транспорта
    public String stop() {
        return ("Транспорт типа " + type + " остановлен.");
    }

    // Геттеры и сеттеры для полей
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
