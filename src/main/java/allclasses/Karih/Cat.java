package allclasses.Karih;

public class Cat {
    public int age;
    public String name;
    public Cat(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String Meow(int count) {

        if (count <= 0) {
            return ""; // Возвращаем пустую строку, если число некорректное
        }

        StringBuilder meows = new StringBuilder();

        for (int i = 0; i < count; i++) {
            meows.append("Meow");
            if (i < count - 1) {
                meows.append(" "); // Добавляем пробел между "Meow"
            }
        }

        return meows.toString();
    }
}
